package Example.agent;

public class UserAgent implements IUser{
    //代理主题：实现了抽象主题接口，持有对真实主题的引用，通常在真实主题上提供额外功能
    //静态代理，IUser每增加一个方法，代理类也得增加一个方法
    private UserImpl user = new UserImpl();
    @Override
    public void save() {
        user.save();//真实主题原本功能
        Log.doLog("保存用户信息");//额外功能
    }
}
