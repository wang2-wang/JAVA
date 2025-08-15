package Example;
/*单例模式，单例指的是单实例，一个类只存在一个实例，无论多少次获取该类的实例，内存中始终只存在同一个对象，
所有对该类的访问都指向这唯一实例，该类提供了一个全局访问点供外部获取该实例
*懒汉模式：必须加锁
* 登记模式
* */
public class LazyExample {
    //用于存储单例实例的静态成员变量,保存类的唯一实例,
    private static LazyExample instance;
    //构造方法必须私有化,防止外部通过new创建实例，确保只能通过getInstance()获取
    private LazyExample(){}
    //静态方法获取单例实例，确保多线程下单例实例创建是安全的,防止多线程环境下创建多个实例。
    //懒汉式是在第一次调用getInstance()时才创建实例
    public static synchronized LazyExample getInstance(){
        //若不存在单例对象，创建对象，否则返回已有对象
        if(instance == null){
            instance = new LazyExample();
        }
        return instance;
    }
}

/*
* Instance 是一个静态变量，用于存储该类的唯一实例
*static属于类而非对象，保证全局唯一性
* */
