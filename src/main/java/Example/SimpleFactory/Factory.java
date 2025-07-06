package Example.SimpleFactory;
//工厂方法模式，将对象创建延迟到子类中，每个具体子类创建一个特定对象，
//通过调用工厂方法获取所需对象
public interface Factory {
    Calculate getBean();
}
