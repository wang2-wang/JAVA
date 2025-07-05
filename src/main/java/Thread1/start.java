package Thread1;

import java.util.LinkedList;

public class start {
    public static void main(String[] args) {
        //创建唯一的共享缓冲区,确保多个线程操作同一个 buffer
        //如果每个 Producter 都 new LinkedList<>()，那么它们的 buffer 是独立的，数据无法共享。
        LinkedList<String> queue = new LinkedList<>();
        //模拟两个生产者
        Producter zs = new Producter("zs",queue);
        Producter ls = new Producter("ls",queue);
        //生成两个生产线程
        new Thread(new ProducterRunnable(zs)).start();
        new Thread(new ProducterRunnable(ls)).start();
        //模拟一个消费者
        Consumer ww = new Consumer("ww",queue);
        //生成一个消费线程
        new Thread(new ConsumerRunnable(ww)).start();
    }
}
