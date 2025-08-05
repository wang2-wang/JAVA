package IO;

import java.io.FileInputStream;
import java.io.IOException;

/*FileInputStream，将本地文件中的数据读取到程序
* 创建字节输入流对象，读数据，释放资源
*
*
* */
public class demo2 {
    public static void main(String[] args) throws IOException {
        //文件不存在直接报错
        FileInputStream fis = new FileInputStream("指定文件路径");
        //一次读取文件一个字节,并移动指针，结果是ASCII码对应的整数。若读不到了返回-1
        int b1 = fis.read();
        //循环读取,要定义第三方变量
        /*
        while(fis.read() != -1){
            System.out.println(fis.read()); 此代码指针会多移动一次而少打印一些数据
        }*/
        int b;
        while((b = fis.read())!= -1){
            System.out.println((char) b);
        }
        fis.close();
    }


}
