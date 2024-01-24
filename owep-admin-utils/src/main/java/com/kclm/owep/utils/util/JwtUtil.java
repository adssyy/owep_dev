/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.utils.util;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.jose4j.jwa.Algorithm;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;

/******************************************
 * 基于jose4j实现的jwt工具类
 * 注：jose4j是JWT官网支持的一种实现，官网给出了7种不同的实现供应商
 * jose4j是一种比较强大的，而且支持的特点最多最全。详情参考：
 * @link https://jwt.io/libraries?language=Java
 *
 * JWT结构由三部份组成，它们是：
 *  标头 (Header)
 *  有效载荷(Payload)
 *  签名(Signature)
 *  所以，JWT的格式是：Header.Payload.Signature  在传输的时候，会将JWT的3部份分别以Base64编码后用.进行连接形成最终的字符串，
 *  如下：
 *  eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqd3Qtc3ViamVjdCIsImlzcyI6Ik9XRVAtVlVFIiwiZXhwIjoxNzAxMTYwMjAxLCJqdGkiOiJSbkxvNE5KX2VDakZYR2ZOZS0tSEdnIiwiaWF0IjoxNzAxMTU2NjAxLCJuYmYiOjE3MDExNTY0ODEsImF1ZCI6Im93ZXAtY2xpZW50IiwidXNlcm5hbWUiOiJhZG1pbiJ9.EbjnZgXpdKiYTQkKmFoYOmbgY24_Rg-e3BG8wtCDy8I
 *  它本质上是经过如下的操作得到的：
 *  JWTStr = Base64(Header).Base64(Payload).HMACSHA256(base64UrlEncode(Header)+"."+base64UrlEncode(Payload),secret)
 *
 * @author yejf
 * @date 2023-11-28
 * @time 13:51
 * @package com.kclm.owep.utils.util
 */
public class JwtUtil {

    private static final String HEADER = "Authorization";
    private static final String SECRET_KEY = "V8yWGvHkRzFCabQlS9N6L0UoDjZXIwKH"; //给一个32位的字符串即可，这个是我们答名密钥
    private static final String ISSUER = "OWEP-VUE";  //签发者，这里以owep-vue做为签发者
    private static final String AUDIENCE = "OWEP-CLIENT"; //受众

    /****
     * 私有化构造
     */
    private JwtUtil() {

    }

    /********************
     * 创建jwt token字符串
     * @param subject 我们这里以登录的用户名做为subject
     * @param expirationTimeInSecond
     * @return
     */
    public static String createToken(String subject, long expirationTimeInSecond) {
        try {
            //1. 创建 jwt内容[jwtclaims]
            JwtClaims claims = new JwtClaims();
            //2.设置属性
            claims.setSubject(subject);
            claims.setIssuer(ISSUER);
            claims.setExpirationTimeMinutesInTheFuture(expirationTimeInSecond / 60);
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //在过期前2分钟内，token不可用。
            claims.setNotBeforeMinutesInThePast(2);
            //受众
            claims.setAudience(AUDIENCE);
            // 添加自定义声明
            //claims.setClaim("username", loginName);
            //如果要添加权限，也可以由外部传入，然后做为payload的内容参加到claims中
            //claims.setStringListClaim("authorities", Arrays.asList(authorities));
            //3. 创建 jws
            JsonWebSignature jws = new JsonWebSignature();

            //设置数据
            jws.setPayload(claims.toJson());
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
            jws.setKey(new HmacKey(SECRET_KEY.getBytes("UTF-8")));
            jws.setDoKeyValidation(false);
            //返回
            return jws.getCompactSerialization();
        }catch (JoseException | UnsupportedEncodingException e) {
            throw new RuntimeException("创建JWT失败", e);
        }
    }

    /****************
     * 解析jwt token
     * @param token
     * @return
     */
    public static JwtClaims parseToken(String token) {
        try {
            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireSubject()
                    .setExpectedIssuer(ISSUER)
                    .setExpectedAudience(AUDIENCE)
                    .setVerificationKey(new HmacKey(SECRET_KEY.getBytes("UTF-8")))
                    .setJwsAlgorithmConstraints(
                            new AlgorithmConstraints(
                                    AlgorithmConstraints.ConstraintType.PERMIT,
                                    AlgorithmIdentifiers.HMAC_SHA256))
                    .build();

            JwtContext jwtContext = jwtConsumer.process(token);
            return jwtContext.getJwtClaims();
        } catch (UnsupportedEncodingException | InvalidJwtException e) {
            throw new RuntimeException("无效的Token【Token过期或是被篡改】", e);
        }
    }

    /****
     * 获取请求头名称
     * @return
     */
    public static String getHeader() {
        return HEADER;
    }

    /**********
     * 判断claims是否过期。如果过期时间比当前时间大，则表示有效【未过期】
     * @param claims
     * @return
     */
    public static boolean isExpiration(JwtClaims claims) {
        //断言
        Assert.notNull(claims, "claims不能为null");
        //获取cliams中的有效时间
        try {
            NumericDate expirationTime = claims.getExpirationTime();
            //获取当前时间
            NumericDate now = NumericDate.now();
            //验证过期时间是否是在now的后面了
            if(expirationTime != null) {
                //
                return expirationTime.isAfter(now);
            } else {
                //没有过期时间，则直接返回true【当然，这个需要根据自己的业务来定,比如没有过期时间时，直接返回false】
                return true;
            }

        } catch (MalformedClaimException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*********************************
     * 续签Token,遵守如下策略
     * 1. 判断给定的claims中的过期时间，是否小于5分钟，如果小于5分钟，则续签，如果不小于，则返回空字符
     * 2. 续签时，需要重新生新的token,这里将会调用上面的createToken方法，并返回新的token
     * @param claims
     * @return
     */
    public static String renewalToken(JwtClaims claims) {
        //断言
        Assert.notNull(claims, "claims不能为null");
        try {
            NumericDate expirationTime = claims.getExpirationTime();
            //获取当前时间
            NumericDate now = NumericDate.now();
            //过期时间减去 5*60 秒
            expirationTime.addSeconds(-5*60);
            //再和当前时间比较，如果还
            if(expirationTime.isBefore(now)) {
                //续签 15分钟
                return createToken(claims.getSubject(), 15*60);
            } else {
                //无需续签
                return "";
            }
        } catch (MalformedClaimException e) {
           throw new RuntimeException("续签Token失败");
        }
    }

    public static void main(String[] args) {
        //
        String jwtStr = createToken( "admin", 4*60);
        //
        System.out.println(jwtStr);

        //解析
        JwtClaims claims = parseToken(jwtStr);
        //
        System.out.println(claims);

        //
        jwtStr = renewalToken(claims);
        System.out.println(jwtStr);
    }
}
