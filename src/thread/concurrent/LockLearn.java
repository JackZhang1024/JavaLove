package thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zfz on 2017/12/5.
 */
public class LockLearn {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new WorkThread(reentrantLock, "A");
        new WorkThread(reentrantLock, "B");
    }

    static class Shared {
        static int count = 100;
    }

    static class WorkThread implements Runnable {
        private ReentrantLock mLock;
        private String mName;

        public WorkThread(ReentrantLock mLock, String mName) {
            this.mLock = mLock;
            this.mName = mName;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                while (Shared.count > 0){
                    mLock.lock();
                    Shared.count--;
                    System.out.println("Thread " + mName + " Left" + Shared.count);
                    Thread.sleep(1000);
                    mLock.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
