package Example.agent;

public class demo1 {
    public static void main(String[] args) {
        UserImpl user = new UserImpl(); //被代理对象
        UserAgent1 agent1 = new UserAgent1(user);   //给到代理类
        IUser proxy = (IUser) agent1.getProxy();    //获取代理对象
        proxy.save();
        //这样IUser增加一个方法，只要proxy.方法就行

    }
}
