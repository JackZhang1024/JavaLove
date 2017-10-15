package thread;

/**
 * 线程优先级
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn06 {

    public static void main(String[] args) {
        MyThread myThread0 = new MyThread("线程0");
        MyThread myThread1 = new MyThread("线程1");
        MyThread myThread2 = new MyThread("线程2");
        MyThread myThread3 = new MyThread("线程3");
        myThread0.setPriority(4);
        myThread1.setPriority(5);
        myThread2.setPriority(7);
        myThread3.setPriority(8);
        myThread0.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

    private static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("线程名称 "+Thread.currentThread().getName()+
                    " 优先级 "+Thread.currentThread().getPriority());
        }
    }
}
