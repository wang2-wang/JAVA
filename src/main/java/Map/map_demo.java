package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class map_demo {
    //给定一个单词列表，返回每个单词出现次数
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        //单词作为key，次数作为value
        System.out.println(map);
        int max = 0;
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for(Map.Entry<String,Integer> entry : entrySet){
            int count = entry.getValue();
            if(count>max){
                max = count;
            }
        }
        for(Map.Entry<String,Integer> entry : entrySet){
            int count = entry.getValue();
            if(count == max){
                System.out.println(entry.getKey());
            }
        }
    }
}
