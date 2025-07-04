package Thread;

public class thread1 {
    /*创建线程 继承Thread类，Thread类已经实现Runnable接口，重写run方法,创建线程子类实例
    线程所实现的功能，写在run方法
    此方法已经继承Thread类，无法继承其他类，不利于功能扩展*/
    public static void main(String[] args) {
        //创建一个线程    ，共三个线程。main,t1和t2
        MyThread t1 = new MyThread();
        t1.setName("线程一");      //线程名
        MyThread t2 = new MyThread();
        t2.setName("线程二");
        //启动线程,线程先后顺序随机，   t1.run不是多线程，只是调用方法，在main线程
        t1.start();
        t2.start();
        for(int i = 0 ; i<100 ; i++){
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }



    }
}
