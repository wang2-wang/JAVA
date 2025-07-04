package Thread;

public class thread2 {
    /*实现Runnable接口
    * 定义线程任务类实现Runnable接口，重写run方法，创建任务类对象
    *创建一个线程（thread）对象，将任务对象交给Thread处理。start启动
    *
    * 可以继续继承其他类。实现其他接口，但不能直接启动，且无返回值
    * */
    public static void main(String[] args) {
        //创建线程任务对象
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        //创建线程对象
        Thread t1 = new Thread(r1);
        t1.setName("线程一");
        Thread t2 = new Thread(r2);
        t2.setName("线程二");
        t1.start();
        t2.start();
        //另一种   用匿名内部类
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i<100 ; i++){
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        });
        Thread t4 = new Thread(() ->{
            for(int i = 0 ; i<100 ; i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }//有返回值加上return
        });

    }
}
