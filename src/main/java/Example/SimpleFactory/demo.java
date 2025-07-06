package Example.SimpleFactory;

public class demo {
    public static void main(String[] args) {
        /*原先
        Calculate triangle = new Minus();
        Calculate square = new Add();
        * */
        Calculate minus = Simple.createBean("Minus");
        System.out.println(minus.calculate(2,1));
        Calculate add = Simple.createBean("Add");
        System.out.println(add.calculate(2,1));
        //Calculate<Integer> add = Simple.createBean("Add");
    }
}
