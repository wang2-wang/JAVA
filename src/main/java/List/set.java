package List;

import java.util.HashSet;
import java.util.Set;

/*
* 不允许重复，不保证元素顺序 Set集合多用于去重
* HashSet：快速查找删除，不保证元素顺序，允许一个null元素
* LinkedSet 保证元素顺序
* TreeSet 对元素默认进行自然顺序排序，也可用提供的比较器进行排序
* */
public class set {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("apple"); hashSet.add("apple"); hashSet.add("banana"); hashSet.add(null);
        System.out.println(hashSet);
        for(String s : hashSet){    //只能用增强for循环来访问
            System.out.println(s);
        }
    }
}
