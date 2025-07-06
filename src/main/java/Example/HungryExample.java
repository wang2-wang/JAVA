package Example;
/*饿汉模式，基于classloader机制避免多线程同步问题，没有加锁，效率高，但类加载会初始化，浪费内存
*
* */
public class HungryExample {
    //一进来就加载对象，存在浪费,用不用都创建，final static让这条语句只执行一次
    private final static HungryExample instance = new HungryExample();
    private HungryExample(){}
    //静态方法，获取单例实例，确保多线程下单例实例创建是安全的，防止多线程环境下创建多个实例。
    public static HungryExample getInstance(){
        return instance;
    }

}
