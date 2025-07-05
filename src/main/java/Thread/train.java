package Thread;

import java.util.Map;

public class train {
    //票包含票名和出票状态所以用map集合
    private Map<String,Boolean> tickets;

    //定义有参构造器，来更明确的创建对象
    public train(Map<String, Boolean> tickets) {
        this.tickets = tickets;
    }
    //出票
    public void ticketing(int id){
        //通过加锁，每次只允许一个线程加锁，加锁后才能访问，访问完毕自动解锁，使同一时刻只有一个线程独享资源
        synchronized (this){    //谁调用方法，就锁谁
            for(String ticket : tickets.keySet()){  //遍历map的键，根据键来获取value
                //若可售，出票并修改状态
                if(tickets.get(ticket)){
                    System.out.println(id+"出票"+ticket);
                    tickets.put(ticket,false);
                    break;
                }
            }
        }
        /*public synchronized void ticketing(){         所有线程都要在调用方法时排队，
            //通过加锁，每次只允许一个线程加锁，加锁后才能访问，访问完毕自动解锁，使同一时刻只有一个线程独享资源
            {    //谁调用方法，就锁谁
                for(String ticket : tickets.keySet()){  //遍历map的键，根据键来获取value
                    //若可售，出票并修改状态
                    if(tickets.get(ticket)){
                        System.out.println("出票"+ticket);
                        tickets.put(ticket,false);
                        break;
                    }
                }
            }*/


        /*for(Map.Entry<String,Boolean> entry : tickets.entrySet()){
            if(entry.getValue()){
                System.out.println("出票："+entry.getKey());
                tickets.put(entry.getKey(),false);
                break;
            }
        }*/
    }
}
