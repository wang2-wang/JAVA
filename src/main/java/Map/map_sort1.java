package Map;

import java.util.Set;
import java.util.TreeSet;

/*若集合中元素是对象，对对象进行排序，则实现Comparable接口和Comparator接口来定义比较器
    或用Collections.sort(对象，new 比较器类)
 * String、Integer等已经实现Comparable接口，调用Collections.sort就能排序
 *
 * 一个类实现comparable接口，重写compareTo(T o)方法即可对对象进行排序,在Student中。
 *  但String和Integer已经实现了其接口，要想改变其排序规则只能用Comparator
 *
 *使用Comparator接口排序，需要创建单独的排序类(比较器)，在排序类中重写compare(T o1, T o2)方法实现定制排序
 *Comparable和Comparator都存在则以Comparator为准
 *Arraylist不能用上面接口进行对象排序，得用Collections.sort()，但student类仍需实现此接口并重写方法，在skuSort中有演示
 */
public class map_sort1 {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();
        students.add(new Student(1002,"jack",88.0));
        students.add(new Student(1003,"rose",65.5));
        students.add(new Student(1004,"lily",89.0));
        students.add(new Student(1001,"lucy",74.0));
        for(Student stu : students){
            System.out.println(stu.toString()); //打印对象
        }
    }
}
