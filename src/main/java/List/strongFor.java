package List;

import java.util.ArrayList;

//所有单列集合和数组才能使用增强for循环
//for(类型 变量名: 数组或集合)
public class strongFor {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");    list.add("bbb");    list.add("ccc");    list.add("ddd");
        /*
        * s就是一个第三方变量，循环过程中依次表示集合中每个数据
        * 修改s，不会改变集合原本数据。并且String是不可变对象，你无法修改String对象本身，只能改变其引用
        * */
        for(String s: list){
            s="qqq";
        }
        System.out.println(list);   //结果不会变
        //但存储的是可变对象，用setter方法还是会变的
        /*class Person {
            String name;
            // getter和setter
        }

        List<Person> people = ...;
        for(Person p : people) {
            p.setName("qqq"); // 这会修改集合中对象的状态
        }*/
    }

}
