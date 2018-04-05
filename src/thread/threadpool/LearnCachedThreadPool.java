package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
 * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
 * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 * Created by zfz on 2018/4/2.
 *
 */
public class LearnCachedThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int index = 0; index < 100; index++) {
            executorService.execute(new CountTask(index));
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
