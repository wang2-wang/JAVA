package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*存储和读取文件中数据
* 流的方向分为输入流（文件到程序）和输出流
*操作文件类型分为字节流（所有类型文件）和字符流（纯文本文件即md，txt）
* 字节流包含inputStream字节输入流和outputStream字节输出流
* 字符流包括Reader字符输入流和Writer字符输出流
* 以上都是抽象类
* */
public class demo1 {
    //FileOutputStream  将程序的数据写入本地文件
    //先创建字节输出流对象，再写数据，后释放资源
    public static void main(String[] args) throws IOException {
        //FileOutputStream()中可以是字符串的路径或者是File对象
        //若所写文件不存在，会创建一个新的文件，但要保证父级路径是存在的，
        //例如”myio\\aaa\\a.txt“   没有a.txt它会创建，但要保证myio\\aaa这个路径存在
        //文件已经存在则会清空文件即 a.txt的内容会清空
        FileOutputStream fos = new FileOutputStream("指定文件路径");
        //write参数是整数，对应ASCII上的字符
        fos.write(97);  //要在一个字节范围内
        //放入多个数据
        byte[] bytes = {96,97,98,99,100};
        fos.write(bytes);
        //放入部分数据，数组，起始索引，个数
        fos.write(bytes,1,3);
        //写数据另一种方法
        String src = "abcde";
        byte[] arr = src.getBytes();    //将字符串变为字节数组，即将字符串中的字符变为代表ASCII码的整数
        fos.write(arr);
        //换行，加上换行符就行
        String warp = "\r\n";
        fos.write(warp.getBytes());
        //续写，在FileOutputStream()写上第二个参数true，打开续写开关, 就可以保留文件内容，在其后添加内容
        FileOutputStream fos1 = new FileOutputStream("指定文件路径",true);
        //使用完流后要释放资源
        fos.close();
    }

}
