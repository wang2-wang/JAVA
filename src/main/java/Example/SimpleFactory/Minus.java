package Example.SimpleFactory;

public class Minus implements Calculate {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
