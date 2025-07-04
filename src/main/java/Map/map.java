package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
    Map集合：键值对集合，键和值一一对应。用于快速检索
    HashMap是无序的，不重复，无索引，键不可以重复
    */
public class map {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("red",1);       //添加元素
        map.put("blue",2);
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
