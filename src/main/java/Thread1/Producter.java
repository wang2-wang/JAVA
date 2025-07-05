package Thread1;

import java.util.LinkedList;
import java.util.Random;

/* 模拟消息队列
* 多个生产者（线程）在一个队列中缓存数据，需要锁住缓存
*一个队列最多缓存10条数据，大于10，任何线程不能写数据，需要线程阻塞否则唤醒所有线程
* 多个消费者（线程）在一个队列拉取数据，并删除拉取的数据，需要锁住缓存
* 若缓存小于等于0，任何线程不能拉取数据，需要线程阻塞否则唤醒所有线程
* */
public class Producter {    //生产者类，有有关方法
    private String name;    //生产者标识，区分不同生产者
    private LinkedList<String> buffer;  //消息集合  缓冲区存储生产者生成的消息
                                        //生产者只管往缓冲区存数据，消费者只管从缓冲区取数据
    public Producter(String name, LinkedList<String> buffer) {
        this.name = name;
        this.buffer = buffer;
    }
    /*发送数据
    * 生产者进入无限循环，生成随机消息。获取buffer的锁，检查缓冲区：
        若已满（size>10），阻塞并等待消费者消费后唤醒。若未满，添加消息到缓冲区，并唤醒可能阻塞的消费者线程。释放锁，进入下一轮循环。
    * */
    public void send(){
        while (true){
            //生成消息，可改为键盘输入，模拟生产者持续产生数据的过程。
            Random random = new Random();
            String messages = "消息"+random.nextInt();
            synchronized (buffer) {
                try {
                    if(buffer.size()>10){
                        System.out.println(name+"线程阻塞");
                        buffer.wait();          //缓冲区大于10，生产者就阻塞了。由消费者唤醒
                    }else if(messages != null){ //缓冲区未满且消息有效
                        buffer.add(messages);   //将消息加入队列，发布消息
                        System.out.println(name+"发布："+messages);
                        buffer.notifyAll();
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
