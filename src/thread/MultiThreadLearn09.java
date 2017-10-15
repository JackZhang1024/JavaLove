package thread;

/**
 * 同步代码块
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn09 {

    private static final Object lock = new Object();
    private static int total_count = 100;

    public static void main(String[] args) {
        Seller seller1 = new Seller("售票员一");
        Seller seller2 = new Seller("售票员二");
        seller1.start();
        seller2.start();
    }

    private static class Seller extends Thread {

        public Seller(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                while (total_count > 0) {
                    synchronized (lock) {
                        if (total_count > 0){
                            Thread.sleep(1000);
                            --total_count;
                            System.out.println(Thread.currentThread().getName() + " 剩余票数 " + total_count);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
