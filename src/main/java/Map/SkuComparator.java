package Map;

import java.util.Comparator;
/*
* String.compareTo() 是 Java 中 String 类的一个方法,按字典顺序比较两个字符串,并返回值
* 区分大小写,不区分大小写的比较，可以使用 compareToIgnoreCase()
* 返回值负数小于。。。
* 基本数据类型（如 int）的比较，可以直接使用减法（o1.getNum() - o2.getNum()），
* 而不需要 compareTo 方法。但如果是对象类型（如 Integer、String），则需要使用 compareTo 方法进行比较。
*
* */

public class SkuComparator implements Comparator<Sku> {     //对 Sku对象进行比较并返回值，
    enum Sort{                                              //TreeSet或(ArrayList+ Collections.sort)会根据返回值进行排序
        ASC,DES
    }
    private String sortField;   //排序字段
    private Sort sort;          //升或降

    public SkuComparator(String sortField) {    //只输入字段，默认升序
        this.sortField = sortField;
        this.sort = Sort.ASC;
    }

    public SkuComparator(String sortField, Sort sort) {
        this.sortField = sortField;
        this.sort = sort;
    }

    @Override
    public int compare(Sku o1, Sku o2) {
        switch (sortField){
            case "name":
                if(this.sort.equals(Sort.ASC)){
                    return o1.getName().compareTo(o2.getName());
                }else{
                    return o2.getName().compareTo(o1.getName());
                }
            case "num":
                if(this.sort.equals(Sort.ASC)){
                    return o1.getNum() - o2.getNum();
                }else{
                    return o2.getNum() - o1.getNum();
                }
            case "price":
                if(this.sort.equals(Sort.ASC)){
                    return (int) (o1.getPrice() - o2.getPrice());
                }else{
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            default: return 0;
        }
    }
}
