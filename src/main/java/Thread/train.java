package Thread;

import java.util.Map;

public class train {
    private Map<String,Boolean> tickets;

    public train(Map<String, Boolean> tickets) {
        this.tickets = tickets;
    }
    //出票
    public void ticketing(){
        for(String ticket : tickets.keySet()){
            //若可售，出票并修改状态
            if(tickets.get(ticket)){
                System.out.println("出票"+ticket);
                tickets.put(ticket,false);
                break;
            }
        }

        /*for(Map.Entry<String,Boolean> entry : tickets.entrySet()){
            if(entry.getValue()){
                System.out.println("出票："+entry.getKey());
                tickets.put(entry.getKey(),false);
                break;
            }
        }*/
    }
}
