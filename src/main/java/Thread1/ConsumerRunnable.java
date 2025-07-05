package Thread1;

public class ConsumerRunnable implements Runnable{
    private Consumer consumer;

    public ConsumerRunnable(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.pull();
    }
}
