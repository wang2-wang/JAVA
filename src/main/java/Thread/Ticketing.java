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

        /*private static Map<String,Boolean> tickets1 = new HashMap<>();    tickets1是static的，整个JVM只有一份，
        static{                              所有实例共享，避免重复创建相同的 Map节省内存。
            tickets1.put("A01",false);      适用于数据不变或需要全局访问的情况
            tickets1.put("A02",true);       在类加载时执行，确保 tickets1 在类首次使用时就已经初始化完成。
            tickets1.put("A03",true);
        }*/
        train g200 = new train(tickets);
        train g300 = new train(tickets);
        //模拟10人抢票
        for(int i = 0;i<10;i++){
            new TicketingThread(g200,i).start();
        }
        for(int i = 0;i<10;i++){
            new TicketingThread(g300,i).start();
        }
    }
}
