package Thread;

import java.util.HashMap;
import java.util.Map;

public class Ticketing {
    //抢票程序
    public static void main(String[] args) {
        Map<String,Boolean> tickets = new HashMap<>();
        tickets.put("A01",false);
        tickets.put("A02",true);
        tickets.put("A03",true);

        train g200 = new train(tickets);
        //模拟100人抢票
        for(int i = 0;i<100;i++){
            new TicketingThread(g200).start();
        }
    }
}
