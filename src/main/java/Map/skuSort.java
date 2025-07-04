package Map;

import java.util.*;

/*
* TreeSet(),括号内为比较器，创建一个基于指定比较器排序的TreeSet
* */
public class skuSort {
     public static void main(String[] args) {
        Set<Sku> skus = new TreeSet<>(new SkuComparator("num"));
        skus.add(new Sku("A",100,200.0));   //TreeSet使用需要实现Comparator或Comparable接口，
        skus.add(new Sku("C",50,1200.0));   //TreeSet 底层使用 TreeMap存储数据
        skus.add(new Sku("D",150,120.0));   //TreeMap在add，contains，remove等操作时会调用比较器重写的compare 方法：
        skus.add(new Sku("B",200,1000.0));  //每次调用 add()时，TreeSet内部会调用 compare()方法，根据返回值，TreeSet自己决定新元素的位置。
        System.out.println(skus);

        Set<Sku> skus1 = new TreeSet<>(new SkuComparator("price",SkuComparator.Sort.DES));
        skus1.add(new Sku("A",100,200.0));
        skus1.add(new Sku("C",50,1200.0));
        skus1.add(new Sku("D",150,120.0));
        skus1.add(new Sku("B",200,1000.0));
        System.out.println(skus1);
        //若为ArrayList
        List<Sku> skus2 = new ArrayList<>();
        skus2.add(new Sku("A",100,200.0));
        skus2.add(new Sku("C",50,1200.0));
        skus2.add(new Sku("D",150,120.0));
        skus2.add(new Sku("B",200,1000.0));
        Collections.sort(skus2,new SkuComparator("price", SkuComparator.Sort.DES));
        System.out.println(skus2);
        //若不想再写一个比较器类，可以用匿名内部类实现，ArrayList和TreeSet都一样
        List<Sku> skus3 = new ArrayList<>();
        skus3.add(new Sku("A",100,200.0));
        skus3.add(new Sku("C",50,1200.0));
        skus3.add(new Sku("D",150,120.0));
        skus3.add(new Sku("B",200,1000.0));
        Collections.sort(skus3, new Comparator<Sku>() {
                   @Override
                   public int compare(Sku o1, Sku o2) {
                      return o1.getNum() - o2.getNum();
                   }
                });
        System.out.println(skus3);




    }
}
