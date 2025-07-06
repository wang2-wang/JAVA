package Example;

public class Demo {
    public static void main(String[] args) {
        //在多线程下创建实例
        for(int i = 0;i<10;i++){
            new Thread(()->{
                LazyExample instance = LazyExample.getInstance();
                System.out.println(instance);   //结果地址都相同，都是同一个实例
            }).start();
        }

        for(int i=0;i<10;i++){
            new Thread(()->{
                HungryExample instance = HungryExample.getInstance();
                System.out.println(instance);
            }).start();
        }

    }
}
