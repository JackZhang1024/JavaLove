package thread.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierLearn
 * 统计三个人赛跑时间 等三个人都到达终点的时候才进行统计
 * 分析：
 * 最先到达的人先等待
 * 第二个到达的人等待
 * 第三个人到达
 * 进行比赛成绩统计
 * <p>
 * Created by zfz on 2017/12/4.
 */
public class CyclicBarrierLearn {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new StaticsThread());
        new Racer("A", cyclicBarrier);
        new Racer("B", cyclicBarrier);
        new Racer("C", cyclicBarrier);

        // cyclicBarrier 可以重用
        new Racer("X", cyclicBarrier);
        new Racer("Y", cyclicBarrier);
        new Racer("Z", cyclicBarrier);
    }

    // 比赛选手
    static class Racer implements Runnable {

        private String mName;
        private CyclicBarrier mCyclicBarrier;

        public Racer(String mName, CyclicBarrier mCyclicBarrier) {
            this.mName = mName;
            this.mCyclicBarrier = mCyclicBarrier;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                doSomeThing();
                mCyclicBarrier.await();
                System.out.println("Racer " + mName + " run over  ");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doSomeThing() {
            try {
                Random random = new Random();
                int time = random.nextInt(5) + 1;
                Thread.sleep(time * 1000);
                System.out.println("Racer " + mName + " 跑了 " + time + " 秒");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    // 统计数据的线程
    static class StaticsThread implements Runnable {

        @Override
        public void run() {
            System.out.println("StaticsThread start working...");
        }
    }
}
