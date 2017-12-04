package thread.concurrent;

import java.util.concurrent.Phaser;

/**
 * 执行完成一个阶段之后 再执行下一个阶段
 * 执行的过程中等待其他注册的party都完成之后 才会进入下一个阶段
 * Created by zfz on 2017/12/5.
 */
public class PhaserLearn01 {

    public static void main(String[] args) {
        int phase = 0;
        Phaser phaser = new Phaser(1);
        new PhaserThread(phaser, "A");
        new PhaserThread(phaser, "B");
        new PhaserThread(phaser, "C");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance(); // 导致main线程挂起 等待阶段一所有的party结束才会执行下一步
        System.out.println("Phase " + phase + " completed ");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance(); // 导致main线程挂起 等待阶段二所有的party结束才会执行下一步
        System.out.println("Phase " + phase + " completed ");

        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance(); // 导致main线程挂起 等待阶段三所有的party结束才会执行下一步
        System.out.println("Phase " + phase + " completed ");

        // Deregister the main thread
        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("The phaser is completed");
        }


    }

    static class PhaserThread implements Runnable {

        private Phaser mPhaser;
        private String mName;

        public PhaserThread(Phaser mPhaser, String mName) {
            this.mPhaser = mPhaser;
            this.mName = mName;
            mPhaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            // 阶段一
            System.out.println("Thread " + mName + " start phase01");
            mPhaser.arriveAndAwaitAdvance(); // 通知已经到达阶段一
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 阶段二
            System.out.println("Thread " + mName + " start phase02");
            mPhaser.arriveAndAwaitAdvance(); // 通知已经到达阶段二
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 阶段三
            System.out.println("Thread " + mName + " start phase03");
            mPhaser.arriveAndDeregister(); // 到达阶段三并解除注册
        }
    }


}
