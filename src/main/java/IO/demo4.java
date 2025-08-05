package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*IO流异常，将可能出异常的放在try，finally中要释放资源
*先定义全局变量而不是在try中的局部变量。fos和fis = null， 再在try中new
* */
public class demo4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
            try{
                fis = new FileInputStream("要拷贝的文件");
                fos = new FileOutputStream("拷贝到的文件");
                int b;
                while ((b = fis.read()) != -1){
                    fos.write(b);
                }
            }catch(IOException  e){
                e.printStackTrace();
            }finally {
                if(fis != null){    //是null就说明，括号的文件不存在
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }

            }

    }
}
