package thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchLearn 有时会希望线程等待
 * 直到一个或者多个任务执行完成 等待线程才会继续执行
 * <p>
 * CountDownLatch在初始创建时带有事件计数器，在释放锁存器
 * 之前，必须发生指定数量的事件。每发生一次事件，计数器减一。
 * 当计数器达到0时，打开锁存器。
 * <p>
 * 关键词 锁存器 CountDownLatch countDown await
 * <p>
 * <p>
 * Created by zfz on 2017/12/4.
 */
public class CountDownLatchLearn {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Thread(new WaitThread(countDownLatch));
        new Thread(new WorkThread(countDownLatch));
    }

    static class WaitThread implements Runnable {

        private CountDownLatch mCountDownLatch;

        public WaitThread(CountDownLatch mCountDownLatch) {
            this.mCountDownLatch = mCountDownLatch;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println("WaitThread starting....");
                mCountDownLatch.await();
                System.out.println("WaitThread Done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class WorkThread implements Runnable {
        private CountDownLatch mCountDownLatch;

        public WorkThread(CountDownLatch mCountDownLatch) {
            this.mCountDownLatch = mCountDownLatch;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                for (int index = 0; index < 5; index++) {
                    System.out.println("Index " + index);
                    Thread.sleep(1000);
                    mCountDownLatch.countDown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
