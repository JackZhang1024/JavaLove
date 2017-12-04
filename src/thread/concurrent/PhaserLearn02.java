package thread.concurrent;

import java.util.concurrent.Phaser;

/**
 * 在推进阶段时， 可以精确的控制发生的操作
 * <p>
 * Created by zfz on 2017/12/5.
 */
public class PhaserLearn02 {

    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4); // 有四个阶段
        new PhaserThread("A", myPhaser);
        new PhaserThread("B", myPhaser);
        new PhaserThread("C", myPhaser);
        new PhaserThread("D", myPhaser);
        System.out.println("starting.........");
        while (!myPhaser.isTerminated()){
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("The phaser is terminated!");
    }


    static class MyPhaser extends Phaser {
        private int mPhaseNum;

        public MyPhaser(int parties, int phaseCount) {
            super(parties);
            this.mPhaseNum = phaseCount;
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            if (phase == mPhaseNum || registeredParties == 0) {
                return true;
            }
            return false;
        }
    }

    static class PhaserThread implements Runnable {
        private String mName;
        private Phaser mPhaser;

        public PhaserThread(String mName, Phaser mPhaser) {
            this.mName = mName;
            this.mPhaser = mPhaser;
            mPhaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (!mPhaser.isTerminated()) {
                System.out.println("Thread " + mName + " is beginning phase " + mPhaser.getPhase());
                mPhaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
