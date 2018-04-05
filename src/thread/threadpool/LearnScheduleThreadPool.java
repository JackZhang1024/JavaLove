package thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 * Created by zfz on 2018/4/2.
 */
public class LearnScheduleThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.schedule(()->{
            System.out.println("定时执行");
        }, 2000, TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(()->{
            System.out.println("延迟2秒，间隔三秒执行：---------"+System.currentTimeMillis());
        }, 2000, 3000, TimeUnit.MILLISECONDS);

    }


}
