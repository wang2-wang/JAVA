package List;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*迭代器，默认指向当前集合0索引处
* hasNext()判断当前位置是否有元素，有就是true
* next()获取当前元素，并将迭代器指针移向下一位置
*/
public class Iterators {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");    list.add("bbb");    list.add("ccc");    list.add("ddd");
        Iterator<String> it = list.iterator();  //获取迭代器对象，并将指针指向0索引处
        while (it.hasNext()) {
            String str = it.next();             //循环中next只能用一次
            System.out.println(str);
        }
       // System.out.println(it.next());  出现异常,循环结束，即遍历完毕，指针不会复位。只能再声明个迭代器对象，才能复位
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()) {
            String str = it1.next();
            if("bbb".equals(str)){
               // list.remove(str);      迭代器遍历时，不能用集合的方法进行增加和删除，只能用迭代器方法删除,添加只能用列表迭代器
                it1.remove();
            }
        }
        System.out.println(list);

        ListIterator<String> it2 = list.listIterator();
        while (it2.hasNext()) {
            String str = it2.next();
            if("bbb".equals(str)){
                it2.add("1");      //列表迭代器可以在遍历中添加和删除
                it2.remove();
            }
        }


    }

}
