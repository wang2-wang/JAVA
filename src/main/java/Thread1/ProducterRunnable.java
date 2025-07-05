package Thread1;
//用第二种创建线程方法
/*
* 将 Producter（生产者）包装成一个可在线程中执行的任务。允许同一个 Producter 被多个线程执行
*Producter与线程管理解耦，使生产者逻辑 (send()) 可以独立于线程启动方式运行。
* Producter 只需关注业务逻辑 (send())，不关心自己是被单线程、多线程、线程池还是其他方式调用。
*线程调度由 Runnable 管理。线程的启动和管理由外部控制
* 可以通过 new Thread()、线程池（ExecutorService）、协程（Kotlin）等方式运行生产者，而无需修改 Producter 类的代码。
* 若无线程类则需，每次启动生产者线程需重复编写 new Thread(() -> p.send()).start()等
* */
public class ProducterRunnable implements Runnable{ //生产者线程类
    private Producter producter;

    public ProducterRunnable(Producter producter) {
        this.producter = producter;
    }

    @Override
    public void run() {
        producter.send();
    }
}
