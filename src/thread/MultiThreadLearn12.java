package thread;

/**
 * 线程间通信 wait() 和 notify() 方法使用
 * 注水和排水的故事：
 * 如果池塘中水没有了 则不要排水 然后等待注水
 * 注水完成后继续通知排水
 * 池塘水空的条件是当前水量为0
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn12 {


    private static class Water {
        public static int dqsl = 5;
        public static int psl = 0;
        public static final Object water = new Water();
    }


    /**
     * 排水线程
     */
    private static class PaiShuiThread extends Thread {

        public PaiShuiThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (Water.water) {
                    if (isEmpty()) {
                        //当水塘没有的时候，等待注水线程注水
                        System.out.println("需要注水线程进行注水...");
                        System.out.println("排水线程1 当前水量" + Water.dqsl + " 排水量 " + Water.psl);
                        try {
                            Water.water.wait();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    } else {
                        //如果水塘还有水，则继续排水
                        Water.psl++;
                        Water.dqsl--;
                        System.out.println("排水线程2 当前水量" + Water.dqsl + " 排水量 " + Water.psl);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                }
            }
        }
    }


    /**
     * 注水线程
     */
    private static class ZhuiShuiThread extends Thread {

        public ZhuiShuiThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                while (true) {
                    Thread.sleep(2000);
                    synchronized (Water.water) {
                        if (isEmpty()) {
                            Water.psl = 0;
                            //Water.dqsl++;
                            Water.dqsl+=5;
                            System.out.println("注水线程进行注水...");
                            Thread.sleep(3000);
                            System.out.println("注水线程 当前水量 " + Water.dqsl);
                            Water.water.notify();
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    private static boolean isEmpty() {
        return Water.dqsl == 0;
    }

    public static void main(String[] args) {
        PaiShuiThread paiShuiThread = new PaiShuiThread("排水线程");
        ZhuiShuiThread zhuiShuiThread = new ZhuiShuiThread("注水线程");
        paiShuiThread.start();
        zhuiShuiThread.start();
    }


}
