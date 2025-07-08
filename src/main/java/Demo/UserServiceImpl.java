package Demo;
@Instance
public class UserServiceImpl implements UserService{
    @AutoDi
    private UserDao userDao;    //因为UserDaoImpl有了@Instance注解所以可以用@AutoDi获取对象而不用new
    @Override
    public void save() {
        userDao.save();
    }
}
