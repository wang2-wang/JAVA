package Demo1;

public class Teddy extends Dog{


    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的泰迪，边吃边蹭");
    }
}
