package Example.agent;

public class UserImpl implements IUser{
    @Override
    public void save() {
        System.out.println("保存用户消息");
        //若不用代理模式，这还得System.out.println("日志信息");，每有一个方法都得再写一句，更改的时候不好改
        //即使写一个日志类还得Log.dolog("日志信息"),还是不好改
    }
}
