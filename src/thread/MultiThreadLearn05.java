package thread;

/**
 * 守护线程
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn05 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程一");
        MyDaemonThread myDaemonThread = new MyDaemonThread("守护线程");
        myDaemonThread.setDaemon(true); // 设置守护线程
        myThread.start();
        myDaemonThread.start();
    }


    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("MyThread current " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyDaemonThread extends Thread {

        public MyDaemonThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            int i = 0;
            while (true) {
                try {
                    System.out.println("DaemonThread " + (i++));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
