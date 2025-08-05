package Stream;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stream1 {
    public static void main(String[] args) {
        //Stream排序
        List<String> list = Arrays.asList("aa","ff","dd");  //快速创建一个固定大小的列表
        //String类自己实现Comparable接口
        list.stream().sorted().forEach(System.out::println);    //aa dd ff


        List<Sku> skus2 = new ArrayList<>();
        skus2.add(new Sku("A",100,200.0));
        skus2.add(new Sku("C",50,1200.0));
        skus2.add(new Sku("D",150,120.0));
        skus2.add(new Sku("B",200,1000.0));
        //先将集合变成流
        //自定义排序，先按价格降序，价格相同则按数量降序
        skus2.stream().sorted(
                (o1,o2) -> {
                    if(o2.getPrice() - o1.getPrice() == 0){             //直接在代码中定义排序逻辑，不需要单独的Comparator类
                        return  o2.getNum() - o1.getNum();              //可以轻松添加多级排序，Collections.sort() 直接修改原集合，而 Stream.sorted() 不修改原数据，
                    }
                    return (int)(o2.getPrice() - o1.getPrice());
                }
        ).forEach(System.out::println);

        //利用商品对象生成订单集合对象    商品名，数量，价格，总价    为了保存这些数据，先创建一个类     然后根据Skus对数据进行转化，所以用map进行转换为order对象
        //一个商品生成一个订单用map，生成多个订单用flatmap
        //先将Skus的数据转换成流
        skus2.stream().map(sku -> {
            //计算总价
            double amount = sku.getNum()*sku.getPrice();
            //sku对象转换成order对象
            order order = new order(
                    sku.getName(),
                    sku.getNum(),
                    sku.getPrice(),
                    amount);
            return order;
        }).forEach(System.out::println);    //重写toString否则返回订单对象的地址
        //流处理完成后，不会保留转换后的 order对象，仅用于打印

        //收集，将流中元素收集成另一数据结构,转换后的所有 order 对象会被存储到 orders 列表中，可后续使用。
         List<order> orders = skus2.stream().map(sku -> {
            //计算总价
            double amount = sku.getNum() * sku.getPrice();
            //sku对象转换成order对象
            order order = new order(
                    sku.getName(),
                    sku.getNum(),
                    sku.getPrice(),
                    amount);
            return order;
        }).collect(Collectors.toList());    //toSet,toMap

    }
}
