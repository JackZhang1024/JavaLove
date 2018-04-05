package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池中只有一个线程，需要执行的任务按照指定的顺序执行
 * Created by zfz on 2018/4/2.
 */
public class LearnSingleThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int index = 0; index < 10; index++) {
            executorService.execute(new LearnSingleThreadPool.CountTask(index));
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
                System.out.println("线程名称 "+Thread.currentThread().getName()+" mIndex " + mIndex);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
