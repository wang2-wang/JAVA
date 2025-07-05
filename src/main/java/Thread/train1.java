package Thread;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//lock类加锁
public class train1 {
    private Map<String,Boolean> tickets;
    private Lock lock = new ReentrantLock();
    public train1(Map<String, Boolean> tickets) {
        this.tickets = tickets;
    }
    public void ticketing(int id){
        try{
            lock.lock();
            for(String ticket : tickets.keySet()){
                if(tickets.get(ticket)){
                    System.out.println(id+"出票"+ticket);
                    tickets.put(ticket,false);
                    break;
                }
            }
        }finally {
            lock.unlock();
        }
        }




}
