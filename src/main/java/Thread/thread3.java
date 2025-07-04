package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class thread3 {
    /*
    * 实现callable接口
    * 定义一个类实现Callable<V>接口，重写call方法，线程实现方法在此，返回值类型为V
    *把Callable类的对象封装成FurtherTask（线程任务对象） FurtherTask实现了Runnable接口
    * 把线程任务对象交给Thread对象，用start启动线程，get方法获取结果
    *
    * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable c1 = new MyCallable(10);
        MyCallable c2 = new MyCallable(100);
        //封装成FurtherTask对象
        FutureTask<Integer> ft1 = new FutureTask<>(c1);
        FutureTask<Integer> ft2 = new FutureTask<>(c2);
        //创建线程对象
        Thread t1 = new Thread(ft1);
        t1.setName("线程一");
        Thread t2 = new Thread(ft2);
        t2.setName("线程二");
        t1.start();
        t2.start();
        //获取结果,线程执行完才能获取
        Integer sum1 = ft1.get();
        Integer sum2 = ft2.get();
        System.out.println("sum1 = "+ sum1);
        System.out.println("sum2 = "+ sum2);

    }
}
