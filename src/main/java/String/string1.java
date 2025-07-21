package String;

import java.sql.SQLOutput;

public class string1 {
    public static void main(String[] args) {
        String str = "hello";
        String s = " Hello ";
        System.out.println(str.length());  //返回字符串长度
        System.out.println(str.isEmpty());  //判断字符串是否为空
        System.out.println(str.equals(s));  //比较字符串内容
        System.out.println(str.equalsIgnoreCase(s));  //忽略大小写比较大小
        System.out.println(str.compareTo(s));  //按字典顺序比较>0大于，...
        System.out.println(str.charAt(4));  //返回指定索引处的字符
        System.out.println(str.indexOf("l"));  //返回字符第一次出现的索引
        System.out.println(str.contains("llo"));  // 判断是否包含指定字符序列
        System.out.println(str.substring(1,3)); // 截取指定范围的子串
        System.out.println(s.trim());   //去除首尾空白字符
        System.out.println(str.concat(s));  // 连接字符串
        System.out.println(str.replace("l","i"));   //替换字符heiio
        System.out.println(String.valueOf(1));  //将基本类型转换为字符串
    }


}
