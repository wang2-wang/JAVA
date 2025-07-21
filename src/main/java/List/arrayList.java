package List;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

/*
* Arraylist大小可变的数组，初始容量是10，后按1.5倍扩大。访问快，但插入删除元素会移动大量数据
* Collection接口下有list接口(Vector、ArrayList和LinkedList)，set接口(HashSet和TreeSet),都是单例集合
    Map接口有HashMap、Hashtable、TreeMap和LinkedHashMap   双列集合
    * 集合中线程安全的: 喂！SHE！  喂是指  vector，S是指 stack， H是指hashtable，E是指：Eenumeration
* */
public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(10); a.add(2);         //添加元素
        //Collections.addAll(a,5,3,1);//一次添加多个数据
        a.add(1,20);           //在下标1插入元素20，原先的10移动到下标2    [1, 20, 10, 2]
        //a.set(1,30);                       //修改下标为1的元素                     [1, 30, 10, 2]
        //a.remove(1);                      优先根据索引删除，a.remove(2)会删除元素10
        //a.remove(Integer.valueOf(2));     删除元素为2的元素
        //Integer i = a.get(1);             根据索引获取元素
        //if(a.contains(10))                集合a中是否包含元素10
        //int k = a.indexOf(10);            返回第一个元素10所在的下标      k=2
        //List<Integer> a1 = a.subList(k,a.size());       //截取集合a     [10, 2]
        System.out.println(a);


        ArrayList<Integer> b = new ArrayList<>();
        b.add(10); b.add(20); b.add(30); b.add(40); b.add(50);
        for(int i= 0 ; i<b.size() ; i++){       //首先b包含30所以先删除10，后整体前移，i变为1，此时下标1的元素为30
            if(b.contains(30)){                 //删除30后，b集合不含30就不删了
                b.remove(i);
            }
        }
        for(int x:b){
            System.out.println(x);  //20 40 50
        }
        //可以为对象类型数组
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("hh",11));
        students.add(new Student("gg",13));
        students.add(new Student("ww",14));
        Student s4 = new Student("hh",11);
        System.out.println(students.contains(s4));  //未重写equals为false


        /*因为list和set都实现了Collection接口，所以都有add/remove方法
        若想list集合add，返回值都为true，因为其允许重复。
        若set集合add。元素不存在返回true，表示添加成功。反之未false   同理remove
        * */

        /*对于contains方法，底层是通过equals方法判断是否存在
        *所以，若集合存储的是对象类型数组，需在实体类中重写equals方法
        * */

    }
}
