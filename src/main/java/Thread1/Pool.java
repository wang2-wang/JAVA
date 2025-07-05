package Thread1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*  线程池
 * 是一种线程复用技术，用完的线程不销毁而是留给下个任务使用。提高了响应速度，对线程进行管理
 * 核心线程会一直存活，当任务数 ≤ corePoolSize 时，线程池会创建新线程处理任务。任务队列为排队等待进入核心线程数的线程数
 * 当任务队列已满且当前线程数 < maximumPoolSize 时，线程池会创建新线程。
 * 当线程数 > corePoolSize时，临时线程经过keepAliveTime时间任务仍未执行则销毁线程
 *线程工厂：默认，用于创建新线程，可以自定义线程名称、优先级
 * 当任务队列已满且线程数达到 maximumPoolSize 时，如何处理新提交的任务。
* */
public class Pool {
    //使用ThreadPoolExecutor类创建线程处理Runnable
    public static void main(String[] args) {
        //核心线程数为2，最大线程数为5（则临时线程为3），闲置超出时间，时间单位，任务队列，线程工厂，拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10
                , TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3)//有界队列
                , new ThreadPoolExecutor.CallerRunsPolicy());//由提交到main线程执行任务。

        /*
         * n<=5，核心+任务队列=2+3=5（2个执行，3个排队）
         * 6，8  核心+任务队列+临时=2+3+（5-2）=8 (5个执行，3个排队）
         *  >8   main线程
         * */
        int n = 5;
        for(int i =0;i<n; i++){
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(10);
                        System.out.println("执行当前任务的线程："+Thread.currentThread().getName());
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            //提交任务
            threadPoolExecutor.execute(run);
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
        //没有中断就一直等待
        while(!threadPoolExecutor.isTerminated()){}
    }
}
