package thread.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用执行器 启动并控制线程的执行
 * 执行器使用的是自己的线程 而不是任务里的线程
 * <p>
 * 接口Executor, ExecutorService
 * <p>
 * 1. ThreadPoolExecutor
 * 2. ScheduleThreadPoolExecutor
 * 3. ForkJoinPool
 * <p>
 * 通常使用Executors工具类来生成对应的执行器
 * <p>
 * 1. static ExecutorService newCachedThreadPool(); // 可以根据需要添加线程， 但是尽可能的利用已有线程
 * 2. static ExecutorService newFixedThreadPool(int numThreads); // 创建指定数目线程的线程池
 * 3. static ScheduleExecutorService newScheduledThreadPool(int numThreads); // 创建支持线程调度的线程池
 * <p>
 * <p>
 * Created by zfz on 2017/12/5.
 */
public class ExecutorsLearn01 {

    public static void main(String[] args) {
        CountDownLatch countDownLatchA = new CountDownLatch(5);
        CountDownLatch countDownLatchB = new CountDownLatch(5);
        CountDownLatch countDownLatchC = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new WorkThread("A", countDownLatchA));
        service.execute(new WorkThread("B", countDownLatchB));
        service.execute(new WorkThread("C", countDownLatchC));
        try {
            countDownLatchA.await();
            countDownLatchB.await();
            countDownLatchC.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        service.shutdown();
        System.out.println("Done");
    }


    static class WorkThread implements Runnable {
        private String mName;
        private CountDownLatch mCountDownLatch;

        public WorkThread(String mName, CountDownLatch mCountDownLatch) {
            this.mName = mName;
            this.mCountDownLatch = mCountDownLatch;
        }

        @Override
        public void run() {
            for (int index = 0; index < 5; index++) {
                System.out.println("Thread  " + mName + " index " + index);
                mCountDownLatch.countDown();
            }
        }
    }


}
