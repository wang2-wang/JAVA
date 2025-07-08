package Demo;
//创建容器
public interface BeanFactory {
    Object getBean(String beanName);//通过对象名获取对象
}
