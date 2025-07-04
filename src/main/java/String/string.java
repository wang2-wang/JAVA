package String;

import java.util.Arrays;

/*
* 由final修饰，所以不能被继承
*String字符串长度固定，内容不能变，使用+改变长度会产生一个新的String实例，会在内存创建新的字符串对象
* String定义的字符串会放在常量池
*StringBuilder和StringBuffer类是可变字符串类
* */

/*
 * 字符串常量池：不可变，可被共享，减少内存使用，存储在堆中
 * 当常量池存在一个值相同的字符串，内存不会开辟空间来存储这个字符串，而是将已存在的字符串地址赋予新的字符串
 * */
public class string {
    public static void main(String[] args) {
        String str = "hello";               //存入常量池
        String s = "hello";                //因为都是赋值定义String，所以将其放入常量池，
                                           //但str的值与s相同且先放入常量池，所以内存不会再开辟空间存储“hello”，而是将地址赋给s，str和s指向同一对象
        String str1 = new String("hello,world");  //与上面不同的是同时在常量池和堆里开辟了空间，创建字符串对象 但str1是堆的地址
        String st = new String("hello,world");    //与str1一样都是new出来的，所以又在堆新创建了一个对象，因此str1和st指向的是不同对象
        System.out.println(str == s);       //true
        System.out.println(str1 == st);     //false


        StringBuffer str2 = new StringBuffer("hello world");        //同样在堆和常量池有两份
        System.out.println(str.charAt(2)); //查找str中2这个下标位置上字符           l
        System.out.println(str.indexOf("l"));     //查找str首次出现l的位置         2
        System.out.println(str.contains(str1));      //判断一个字符串是否包含另一个字符串
        System.out.println(str.replace("e","E"));   //将str中的e替换为E       hEllo
        System.out.println(Arrays.toString(str1.split(",")));   //将字符串以指定格式拆分为字符串数组     [hello, world]
        System.out.println(str2.append(2)); //StringBuffer和builder的方法，在原本字符串末尾增加内容，而不生成新字符串  hello world2
        System.out.println(str2.insert(2,"e")); //在指定位置插入内容   heello world2
        System.out.println(str2.delete(2,4)); //删除了2到3处的内容   helo world2

        String s8 = "123";
        String s9 = "456";
        String s10 = "123"+"456";
        String s11 = s8+s9;                   //相当于new了一个对象
        String s12 = "123456";
        System.out.println(s10 == s11);     //false
        System.out.println(s10 == s12);     //true

        /*
        * intern() 的作用:如果字符串常量池中已经存在该字符串，则直接返回池中的引用。
        *               如果字符串常量池中不存在该字符串，则将该字符串添加到池中，并返回它的引用。
        * */
    }
}
