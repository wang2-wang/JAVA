package MethodCitation;


import java.util.Arrays;
import java.util.Comparator;

/*  引用处必须是函数式接口，被引用方法必须已经存在，被引用方法的形参和返回值需与抽象方法保持一致
*   被引用方法的功能要满足当前需求
*
* */
public class Demo1 {
    public static void main(String[] args) {
        //创建一个数组，倒序排列
        Integer[] arr = {3,5,4,1,6,2};
        //匿名内部类
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //lambda    Comparator是函数式接口
        Arrays.sort(arr,(o1, o2)-> (o2-o1));
        //方法引用  类名：：方法
        //引用处必须是函数式接口，
        // 被引用方法必须已经存在， subtraction已经提前定义好
        // 被引用方法的形参和返回值需与抽象方法保持一致   subtraction和compare方法
        Arrays.sort(arr,Demo1::subtraction);
        //  方法引用分类。引用静态，成员(引用其他类(其他类对象：：方法)，本类(this：：方法名)，父类(super：：方法名)的成员方法)，构造方法(类名：：new)

    }

    public static int subtraction(int num1,int num2){return num2-num1;}


}
