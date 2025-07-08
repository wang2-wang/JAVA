package Demo;
@Instance//在容器中创建UserDaoImpl对象
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("执行了dao的sava");
    }
}
