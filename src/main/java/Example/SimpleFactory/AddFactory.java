package Example.SimpleFactory;

public class AddFactory implements Factory{
    @Override
    public Calculate getBean() {
        return new Add();
    }
}
