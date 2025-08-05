package IO;

import java.io.*;


//字节缓冲流：  BufferedInputStream，BufferedOutputStream
//自带长度为8192的缓冲区，对基本流进行包装
public class demo8 {
    public static void main(String[] args) throws IOException {
        //利用字节缓冲流拷贝文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("读取文件路径"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("写入文件路径"));
        int b;
        while ((b=bis.read()) != -1){
            bos.write(b);
        }

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();

    }
}
/*流程：
* 数据源——基本流——缓冲输入流——内存（缓冲区——第三方变量——缓冲区）——缓冲输出流——基本流——目的地
* */