package IO;

import java.io.*;

/*  字符缓冲流   BufferedReader和BufferedWriter
*   主要是其有两个好用的方法
* */
public class demo9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("读取文件路径"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("写入文件路径",true));
        br.readLine();  //读取一行的数据，但不会换行
        String line;
        while((line = br.readLine()) != null){
            bw.newLine();   //跨平台换行
        }
        br.close();
        bw.close();

    }
}
