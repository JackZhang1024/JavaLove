package thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量的学习
 * 利用信号量保证了加操作和减操作不会交叉进行
 * <p>
 * Created by zfz on 2017/12/4.
 */
public class SemaphoreLearn01 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncreaseThread(semaphore, "A");
        new DecreaseThread(semaphore, "B");
    }

    static class Shared {
        static int count = 0;
    }

    // 增大数量线程
    static class IncreaseThread implements Runnable {

        private Semaphore mSemaphore;
        private String name;

        public IncreaseThread(Semaphore mSemaphore, String name) {
            this.mSemaphore = mSemaphore;
            this.name = name;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread" + name + " isWaitingFor a permit");
                mSemaphore.acquire();
                System.out.println("Thread" + name + " 获得了 permit");
                for (int index = 0; index < 5; index++) {
                    Shared.count++;
                    System.out.println("Increase " + Shared.count);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread " + name + " release permit");
                mSemaphore.release();
            }
        }
    }

    // 减小数量线程
    static class DecreaseThread implements Runnable {
        private Semaphore mSemaphore;
        private String name;

        public DecreaseThread(Semaphore mSemaphore, String name) {
            this.mSemaphore = mSemaphore;
            this.name = name;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread" + name + " isWaitingFor a permit");
                mSemaphore.acquire();
                System.out.println("Thread" + name + " 获得了 permit");
                for (int index = 0; index < 5; index++) {
                    Shared.count--;
                    System.out.println("Decrease " + Shared.count);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread " + name + " release permit");
                mSemaphore.release();
            }
        }
    }

}
