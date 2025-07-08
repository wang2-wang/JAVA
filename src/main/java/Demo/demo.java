package Demo;
//模拟IOC容器，在容器中创建单例对象并管理依赖关系，使用注解加载Bean
// 容器即对象工厂：在此创建对象并保存到容器中，且确保其为单例
//这样直接定义变量且加上注解不用new
//为了保证保存的对象唯一可以用Map集合的key来确保唯一性，且Map集合还好取对象Map<对象名，对象>
//Spring创建对象：对象上的注解@Resource（依赖注入不用new对象，到容器中取Bean）和类上的注解@Component（把类实例化丢到容器去，在容器中创建Bean）
public class demo {
    public static void main(String[] args) {
        ApplicationContext context= new ApplicationContext("Demo");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.save();
        UserDao userDao = (UserDao) context.getBean("userDaoImpl");
        userDao.save();
    }
}

