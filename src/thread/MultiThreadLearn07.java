package thread;

/**
 * 线程礼让
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn07 {

    private static MyThread myThread;
    private static MyThread2 myThread2;

    public static void main(String[] args) {
        myThread = new MyThread("线程一");
        myThread2 = new MyThread2("线程二");
        myThread.start();
        myThread2.start();
    }

    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                for (int i =0; i <30; i++) {
                    System.out.println(Thread.currentThread().getName()+" current "+i);
                    if (i == 3) {
                        Thread.yield(); // 将CPU分给的线程一的时间让给线程二
                    }
                    Thread.sleep(1000);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {

        public MyThread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try{
                for (int i =0; i <30; i++) {
                    System.out.println(Thread.currentThread().getName()+" current "+i);
                    Thread.sleep(300);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
