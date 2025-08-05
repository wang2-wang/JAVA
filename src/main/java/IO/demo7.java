package IO;

import java.io.FileWriter;
import java.io.IOException;

public class demo7 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("要写入的文件路径",true);
        //因为为字符输出流，所以可以超过字节范围，会根据字符集的编码方式进行编码，将编码后的数据写入文件
        fw.write(44);   //写入一个字符
        fw.write("哈哈哈");    //写入一个字符串，可写入一部分
        fw.write("哈哈哈",2,1);
        char[] chars = {'a','b','c','d'};
        fw.write(chars);    //写入一个字符数组，可写入一部分
        fw.flush();
        //FileWrite底层是先根据字符集编码方式编码成字节，
        //write放入缓冲区，缓冲区满了，自动保存到本地文件
        //不满也可以手动刷新flush，刷新之后还可以继续往文件写数据
        //close方法也会将缓冲区数据保存到本地文件
        fw.close();
    }
}
