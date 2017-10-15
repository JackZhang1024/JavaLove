package thread;

/**
 * Created by zfz on 2017/10/15.
 * 线程休眠
 */
public class MultiThreadLearn03 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程一");
        myThread.start();
    }

    private static class MyThread extends Thread{

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try{
                for (int i= 0; i<20; i++){
                    System.out.println("current "+i);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
