package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//文件拷贝，创建对象，拷贝（边读边写）,释放资源（先开的流后关闭）
public class demo3 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("要拷贝的文件");
        FileOutputStream fos = new FileOutputStream("拷贝到的文件");
        int b;
        while ((b = fis.read()) != -1){
            fos.write(b);
        }
        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);    //拷贝耗时ms

        //拷贝文件过大，速度慢（一次只读取一个字节）
        //一次多取多个数据，即一次读取一个字节数组的数据，每次读取会尽可能把数组装满
        //数组长度应为1024的整数倍   1024*1024*5  5M
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);  //2 ,fis.read已经将数据读取到数组中了
        System.out.println(new String(bytes,0,len));    //读多少写多少
                                //因为不再是只读取一个字符，所以使用new String()将实际读取到的字节转换为字符串
        //另一种拷贝的while方法
        int lens;
        byte[] bytes1 = new byte[1024*1024*5];
        while ((lens = fis.read(bytes1)) != -1){
            fos.write(bytes1,0,lens);
        }

    }

}
