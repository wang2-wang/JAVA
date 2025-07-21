package List;
/*
* set集合去重
* 核心在于equals()方法，此方法是判断两个对象内容是否相同
* hashCode()比较哈希码
* 当Set集合的元素是对象时，需在自定义类中重写equals和hashCode方法，使其对比内容而不是地址
* ==基本数据类型时比较值，引用类型比较的是地址
* equals比较值，重写后比较内容,因为String类重写了该方法，所以字符串间比较的是内容
* */
public class set1 {
}
