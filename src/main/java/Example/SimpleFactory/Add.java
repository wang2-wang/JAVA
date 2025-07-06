package Example.SimpleFactory;

public class Add implements Calculate {

    @Override
    public int calculate(int num1,int num2) {
        return num1+num2;
    }
}
/*public class Add implements Calculate<Integer> {

    @Override
    public Integer Calculate(Integer num1,Integer num2) {
        return num1+num2;
    }
}
*/
