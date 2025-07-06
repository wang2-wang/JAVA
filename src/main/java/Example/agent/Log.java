package Example.agent;

public class Log {
    public static void doLog(String msg){
        System.out.println("写"+msg+"的日志");
    }
    //若无static 在UserAgent中需在调用前new一个对象，再调用
    //在动态代理中，要先在UserAgent中定义privat Log log，再将构造器参数增加，在demo1中要new一个对象，构造器增加参数
}
