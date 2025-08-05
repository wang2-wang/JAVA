package Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
/*
* 执行查找、过滤和映射数据操作。提供了Stream API对集合数据进行操作，
不会保存数据，不会修改原来的数据源。会将操作后的数据操作到另一个对象中
* 单列集合使用.stream，双列无法直接使用，得先keySet或entrySet再 ，数组也有.stream，散碎数据用.of
* */
public class stream {
    public static void main(String[] args) {
        //Stream流的静态方法 of和iterate
        Stream<Integer> stream2 = Stream.of(6,4,6,7,3,9,8,10,12,14,14);
        Stream<Integer> stream3 = Stream.iterate(0,(x)->x+2).limit(6);  // 0 2 4 6 8 10

        //筛选与切片
        Stream<Integer> newStream = stream2.filter(s -> s>5)    //过滤大于5的    6 6 7 9 8 10 12 14 14
                .distinct()         //去重    6 7 9 8 10 12 14
                .skip(2)        //跳过前二个     9 8 10 12 14
                .limit(2);  //限制显示2个      9 8
        newStream.forEach(System.out::println);

        /*映射
        *  map：接收一个函数，该函数会应用到每个元素，并将其映射到新的元素上，（一进一出）
        *  flatMap 接收一个函数，将流中每个元素都换成另一个流，然后把所有流连接成一个流 （一进多出）
        */
        List<String> list1 = Arrays.asList("a,b,c","10,20,30");
        //将每个元素转换成一个新的且不带逗号的元素，一进一出
         Stream<String> s1 = list1.stream().map(s -> s.replaceAll(",",""));
        s1.forEach(System.out::println);    //abc 102030


        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();  //集合转换成流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);   //将数组转换成流
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("aaa",111);hm.put("bbb",112);hm.put("ccc",113);hm.put("ddd",114);
        hm.keySet().stream().forEach(s -> System.out.println(s));   //此处s代表键
        hm.entrySet().stream().forEach(s-> System.out.println(s));  //此处s代表键值对

    }
    

}
