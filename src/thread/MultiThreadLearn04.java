package thread;

/**
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn04 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程一");
        myThread.start();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("4 主线程休眠终止");
            e.printStackTrace();
        }
        myThread.interrupt();
        System.out.println("5 主线程结束");
    }


    private static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("1 进入我的线程");
            try{
                Thread.sleep(30*1000);
            }catch (InterruptedException e){
                System.out.println("2 我的线程休眠终止");
            }
            System.out.println("3 我的线程结束");
        }
    }
}
