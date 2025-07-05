package Thread1;

import java.util.LinkedList;

public class Consumer {
    private String name;    //消费者标识，区分不同消费者
    private LinkedList<String> buffer;

    public Consumer(String name, LinkedList<String> buffer) {
        this.name = name;
        this.buffer = buffer;
    }
    //获取数据
    public void pull(){
        while (true){
            synchronized (buffer){
                try{
                    if(buffer.size()>0){
                        System.out.println(name+"拉取消息"+buffer.getFirst());
                        buffer.removeFirst();   //获取消息后，删除在缓冲区的一条消息，这样缓冲区消息就小于10
                        buffer.notifyAll();
                    }else {
                        buffer.wait();      //缓冲区无数据，消费者就阻塞了，由生产者唤醒
                        System.out.println(name+"线程堵塞");
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
