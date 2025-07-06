package Example.agent;
/*JDK动态代理
使用反射解析目标对象的属性，方法。根据解析的内容生成代理类，就是在运行时生成一个代理对象
所有的方法调用转发给指定的处理器

需要事先实现InvocationHandler接口，重写invoke方法，包括三个参数
proxy代理对象，通过该参数调用的方法是被代理后的方法
method，要调用的方法
args 方法中的参数

*/
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserAgent1 implements InvocationHandler {
    private Object target; //目标对象即真实主题，用set或构造器赋值

    public UserAgent1(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //遍历真实主题中有哪些方法，调用方法（method.invoke（target，args））并可以增加功能
        //这样在UserImpl每增加一个方法，代理类不用再增加一个方法
        String methodName = method.getName();
        Object o = method.invoke(target,args);
        Log.doLog(methodName);//写 调用方法的名字 的日志
        return o;
    }
    //调用Proxy的的静态方法newProxyInstance来创建代理对象  默认这样
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),   //被代理对象的类加载器（确保代理类和目标对象属于同一类加载器所加载的类）
                target.getClass().getInterfaces(),  //被代理对象的实现接口（确保共同的父类接口）
                this);                              //代理对象
    }
}
