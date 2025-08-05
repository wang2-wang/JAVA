package MethodCitation;

import java.util.ArrayList;
import java.util.Collections;

public class Demo2 {
    public static void main(String[] args) {
        //引用静态方法
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        //String都变成Integer
        list.stream().map(s -> Integer.parseInt(s)).forEach(System.out::println);
        list.stream().map(Integer::parseInt).forEach(System.out::println);

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"张无忌","周芷若","赵宁","张强","张三丰");
        list1.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);



    }

}
