package Example.SimpleFactory;
/*
* 工厂getBean，子工厂实现工厂，重写方法new对象，产品
* */
public class demo2 {
    public static void main(String[] args) {
        Factory addFactory = new AddFactory();
        Calculate addBean = addFactory.getBean();
        System.out.println(addBean.calculate(2,1));

        Factory minusFactory = new MinusFactory();
        Calculate minusBean = minusFactory.getBean();
        System.out.println(minusBean.calculate(2,1));
    }

}
