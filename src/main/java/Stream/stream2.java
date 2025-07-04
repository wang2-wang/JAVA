package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stream2 {
    //Stream不会对数据进行修改，但要修改这个叫做消费 peek，修改后会生成一个新的对象
    public static void main(String[] args) {
        List<Sku> skus2 = new ArrayList<>();
        skus2.add(new Sku("A",100,200.0));
        skus2.add(new Sku("C",50,1200.0));
        skus2.add(new Sku("D",150,120.0));
        skus2.add(new Sku("B",200,1000.0));
        //将数量>=150的，降价10%
        skus2.stream().filter(sku -> sku.getNum()>=150)
                .peek(sku -> sku.setPrice(sku.getPrice()*(0.9)))
                .forEach(System.out::println);

        //匹配
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        boolean allMatch = list.stream().allMatch(e ->e>10);    //所有元素符合断言返回true
        boolean noneMatch = list.stream().noneMatch(e ->e>10);  //每个都不
        boolean anyMatch = list.stream().anyMatch(e ->e>10);    //有一个
        Integer findFirst = list.stream().findFirst().get();    //获取流中第一个
        Integer findAny = list.stream().findAny().get();        //任意一个
        long count = list.stream().count();     //元素个数
        Integer max = list.stream().max(Integer::compareTo).get();  //找最大








    }

}
