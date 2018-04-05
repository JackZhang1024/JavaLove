package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池最大使用的线程数量是固定的，当任务数超过固定的线程数时，则会重用已经执行完任务的线程
 * 如果没有可重用的线程，则会加入队列进行等待执行
 * Created by zfz on 2018/4/2.
 */
public class LearnNewFixedThreadPool {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for (int index = 0; index < 10; index++) {
            executorService.execute(new LearnCachedThreadPool.CountTask(index));
        }
        executorService.shutdown();
    }

    static class CountTask extends Thread {
        private int mIndex;

        public CountTask(int index) {
            this.mIndex = index;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程名称 "+Thread.currentThread().getName() + " mIndex "+mIndex);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
