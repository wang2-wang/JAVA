package Example;
// 登记模式：只有调用getInstance方法，才会装载内部类，从而实例化instance
public class HolderExample {
    //静态内部类用于存储单例实例的静态成员变量
    private static class holder{
        private static final HolderExample INSTANCE = new HolderExample();
    }
    private HolderExample(){}
    public static HolderExample getInstance(){
        return holder.INSTANCE;
    }

}
