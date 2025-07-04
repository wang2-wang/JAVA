package Thread;

public class TicketingThread extends Thread{
    //购票
    public train train;

    public TicketingThread(train train) {
        this.train = train;
    }

    @Override
    public void run() {
        train.ticketing();
    }
}
