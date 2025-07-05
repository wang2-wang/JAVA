package Thread;

public class TicketingThread extends Thread{
    //购票
    private train train;
    private Integer id;
    //确保多个线程同时操控同一个train类，明确线程需要train类才能运行
    public TicketingThread(train train,int id) {
        this.train = train;
        this.id = id;
    }

    @Override
    public void run() {
        train.ticketing(id);
    }
}
