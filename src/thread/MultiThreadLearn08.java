package thread;

/**
 * 同步代码 售票员错误实例代码
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn08 {

    private static int total_count =100;

    public static void main(String[] args) {
         Seller1 seller1 = new Seller1("售票员一");
         Seller2 seller2 = new Seller2("售票员二");
         seller1.start();
         seller2.start();
    }

    private static class Seller1 extends Thread{

        public Seller1(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                while (total_count > 0 ){
                    Thread.sleep(1000);
                    --total_count;
                    System.out.println(Thread.currentThread().getName()+" 剩余票 "+total_count);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private static class Seller2 extends Thread{

        public Seller2(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            try {
                while (total_count > 0){
                    Thread.sleep(1000);
                    --total_count;
                    System.out.println(Thread.currentThread().getName()+" 剩余票 "+total_count);
                }
            }catch (Exception e){
                e.getMessage();
            }
        }
    }


}
