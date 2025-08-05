package List;
/*
* set集合去重
* 核心在于equals()方法，此方法是判断两个对象内容是否相同
* hashCode()比较哈希码
* 当Set集合的元素是对象时，需在自定义类中重写equals和hashCode方法，使其对比内容而不是地址
* ==基本数据类型时比较值，引用类型比较的是地址
* equals比较值，重写后比较内容,因为String类重写了该方法，所以字符串间比较的是内容
* */

import java.util.TreeSet;

/*没有重写hashCode，不同对象哈希值不同
 *重写了，不同对象属性值相同，哈希值相同   Student s1 = new Student(“zhangsan”，23)；
 *Student s2 = new Student(“zhangsan”，23)；  s1和s2哈希值相同
 * 小部分情况，不同属性值或不同地址计算的哈希值可能相同，因为哈希值范围大小才42亿
 * */
/*Hashset<String> hashset = new Hashset<>();
    *创建了个默认长度为16，加载因子为0.75的数组，根据元素哈希值和数组长度计算出应存位置
    *判断当前位置是否为null，是就存，不为null，调用equals方法比较属性值
    * 一样不存，不一样就会将新元素挂在老元素下面形成链表
    * 当存了16*0.75=12时，会扩容两倍。当链表>8且数组长度>=64，链表会变为红黑树
    * */
/*LinkedHashSet：有序，不重复，无索引
*此处有序指存储和取出元素顺序的一致。底层依旧为哈希表，只是每个元素额外多了一个双向链表，记录存储顺序
* */
public class set1 {
    //5个学生对象，姓名，年龄，语文成绩，数，英，排序
    public static void main(String[] args) {
        Student1 s1 = new Student1("zhangsan",23,90,99,50);
        Student1 s2 = new Student1("lisi",24,90,98,50);
        Student1 s3 = new Student1("wangwu",25,95,100,30);
        Student1 s4 = new Student1("zhaoliu",26,60,99,70);
        Student1 s5 = new Student1("qainqi",26,70,80,70);
        TreeSet<Student1> ts = new TreeSet<>();
        ts.add(s1);ts.add(s2);ts.add(s3);ts.add(s4);ts.add(s5);
        System.out.println(ts);
    }
}