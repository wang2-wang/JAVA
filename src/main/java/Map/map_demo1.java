package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class map_demo1 {
    public static void main(String[] args) {
        String s = "aababcabcdabcde";
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for(int i = 0 ; i<s.length();i++){
            char c = s.charAt(i);
            if(tm.containsKey(c)){
                int count = tm.get(c);
                count++;
                tm.put(c,count);
            }else {
                tm.put(c,1);
            }
        }
        //System.out.println(tm); {a=5, b=4, c=3, d=2, e=1}     字符串拼接：Stringbuilder和StringJoiner
        StringBuilder sb = new StringBuilder();
        tm.forEach((key,value) -> sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);



    }
}
