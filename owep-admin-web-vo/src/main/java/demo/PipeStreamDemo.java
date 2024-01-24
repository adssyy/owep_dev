/**************************
 * xxx 公司版权所有，未经同意，不可以随意复制、转发
 */
package demo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

/******************************************
 *
 *
 * @author yejf
 * @date 2023-12-05
 * @time 16:11
 * @package demo
 */
public class PipeStreamDemo {

    public static void main(String[] args) {
        //
        byte[] data = new byte[10];
        byte[] store = new byte[20];
        //
        Arrays.fill(data, (byte) 1);
        //
        try(PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();) {
            //联系
            pipedInputStream.connect(pipedOutputStream);
            int count = 1;
            //先写入数据
            System.out.println("第1次写入数据");
            pipedOutputStream.write(data, 0, data.length);
            System.out.println("第1次写入完成");
            while(count < 100) {
                System.out.printf("第%d次读数据\n", count);
                pipedInputStream.read(store,0, store.length);
                System.out.printf("第%d次读到的字节是：%s\n",count,Arrays.toString(store));
                //再次写入
                System.out.printf("第%d次写入数据\n", count+1);
                pipedOutputStream.write(data);
                System.out.printf("第%d次写入完成.\n",count+1);
                //
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
