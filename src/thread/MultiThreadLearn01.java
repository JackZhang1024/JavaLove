package thread;

/**
 * Created by zfz on 2017/10/14.
 */

public class MultiThreadLearn01 {

    public static void main(String[] args) {

        MyThread thread = new MyThread("线程1");
        thread.start();
    }

    private static class MyThread extends Thread {

        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("当前线程名称 " + Thread.currentThread().getName());
        }
    }

}
