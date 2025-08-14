package IO;

import java.io.FileReader;
import java.io.IOException;

/*字符流，输入流：一次读一个字节，遇到中文，一次读多个字节（utf-8）3个
        输出流：数据按照指定编码方式进行编码，变成字节再写入文件中
        字符输入流是读取字节数据，将字节数据解码为字符数据，并存入缓冲区
        字符输出流是将字符数据编码为字节数据，存入缓冲区，放入文件
*/
public class demo6 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("myio\\a.txt");  //关联文件并创建缓冲区
        int b;
        /*  read() 默认一次读取一个字节，遇到中文会读多个字节
            判断缓冲区是否有数据，
            没有就从文件获取数据，装到缓冲区并尽可能装满.文件中没有数据返回-1
            有就从缓冲区读取
        *   读取之后，方法底层会解码，成字符集上的数字
        *   (char)强转，就会将数字变为中文
        * */
        while ((b = fr.read()) != -1){      //
            System.out.println((char) b);
        }
        /*  read(有参)将读取数据，解码，强转合并，把强转之后的字符放到数组中
        *
        * */
        char[] chars = new char[2];
        int len;
        while((len = fr.read())!= -1){
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }
}
