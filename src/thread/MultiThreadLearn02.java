package thread;

/**
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn02 {
    private static MyThread1 myThread1;
    private static MyThread2 myThread2;

    public static void main(String[] args) {
        myThread1 = new MyThread1("线程一");
        myThread2 = new MyThread2("线程二");
        myThread1.start();
        myThread2.start();
    }

    private static class MyThread1 extends Thread {

        public MyThread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程名称 " + Thread.currentThread().getName() + " " + i);
                    Thread.sleep(2000);
                    if (i == 5) { // 当线程一数到5的时候 线程二抢占属于CPU分给线程一的时间片 执行线程二
                        myThread2.join();
                    }
                }
            }catch (InterruptedException e){
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
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程名称 " + Thread.currentThread().getName() + " " + i);
                    Thread.sleep(2000);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
