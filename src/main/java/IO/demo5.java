package IO;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class demo5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "字符串";
        byte[] bytes1 = str.getBytes(); //默认方式编码，将字符串中的字符变为代表ASCII码的整数
        System.out.println(Arrays.toString(bytes1));
        byte[] bytes2 = str.getBytes("GBK");    //按GBK编码
        String str2 = new String(bytes1);   //默认方式解码
        String str3 = new String(bytes2,"GBK"); //GBK解码
        String str4 = new String(bytes1,"GBK"); //会出现乱码，因为编码和解码方式不同
    }
}
