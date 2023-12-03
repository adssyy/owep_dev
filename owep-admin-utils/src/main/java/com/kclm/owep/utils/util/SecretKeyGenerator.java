/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package com.kclm.owep.utils.util;

/******************************************
 *
 *
 * @author yejf
 * @date 2023-11-28
 * @time 13:55
 * @package com.kclm.owep.utils.util
 */
import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static void main(String[] args) {
        // 生成一个 256 位的随机字节数组
        byte[] randomBytes = generateRandomBytes(32);

        // 使用 Base64 编码将字节数组转换为字符串
        String secretKey = encodeBase64(randomBytes);

        System.out.println("Generated Secret Key: " + secretKey);
    }

    private static byte[] generateRandomBytes(int length) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        return randomBytes;
    }

    private static String encodeBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
