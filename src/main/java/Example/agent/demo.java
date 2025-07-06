package Example.agent;
//客户端
public class demo {
    public static void main(String[] args) {
        //代理前
        UserImpl user = new UserImpl();
        user.save();
        System.out.println("----------");
        //代理后
        UserAgent agent = new UserAgent();
        agent.save();
    }
}
