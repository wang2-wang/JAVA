package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
    Map集合：键值对集合，键和值一一对应。用于快速检索
    HashMap是无序的，不重复，无索引，键不可以重复，原理与hashset类似，键存储自定义对象，需重写hashCode和equals方法。值则不用
    *HashMap<String> hashmap = new HashMap<>();
    *创建了个默认长度为16，加载因子为0.75的数组，根据元素哈希值和数组长度计算出应存位置
    *判断当前位置是否为null，是就存，不为null，调用equals方法比较键的属性值
    *一样会覆盖，不一样就会将新元素挂在老元素下面形成链表或红黑树
    *当存了16*0.75=12时，会扩容两倍。当链表>8且数组长度>=64，链表会变为红黑树
    */
public class map {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("red",1);       //添加/覆盖元素，添加数据若键不存在，直接将键值对添加到map,返回null
        map.put("blue",2);      //键是存在的就将原有的键值对对象覆盖，并把被覆盖的值返回
        //System.out.println(map.put("blue",3));  2
        map.put("green",3);
        System.out.println(map);
        //遍历  key找值
        int x = map.get("red");     //get获取键对应的值
        System.out.println(x);
        //遍历 增强for
        for(String key : map.keySet()){                   //返回该 Map中所有key组成的Set集合。 遍历键
            System.out.println(key + ":" + map.get(key));//（因为 Map 的 key 不允许重复，所以用 Set存储）
        }
        for(Integer value : map.values()){  //values()获取所有值  遍历值
            System.out.println(value + " ");
        }
        //迭代器遍历
        //next()是 Iterator接口的核心方法，返回当前指向的元素（在这里是 Map 的 key），并将迭代器的指针移动到下一个元素。
        Iterator<String> keyIterator = map.keySet().iterator(); //调用 Set 的 iterator() 方法，返回一个迭代器
        while(keyIterator.hasNext()){
            String key = keyIterator.next();//获取当前 key 并移动指针
            System.out.println(key+ ":" + map.get(key)+ " ");
        }
        //entry遍历，遍历key和value
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());  //是Entry有getKey和getValue方法
        }

    }
}
