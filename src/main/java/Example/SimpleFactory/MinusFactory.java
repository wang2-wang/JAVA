package Example.SimpleFactory;

public class MinusFactory implements Factory{
    @Override
    public Calculate getBean() {
        return new Minus();
    }
}
