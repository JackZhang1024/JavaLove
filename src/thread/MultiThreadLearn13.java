package thread;

/**
 * 单个生产者和单个消费者模式
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn13 {

    public static void main(String[] args) {
        // 注意 我们使用的锁必须为同一个对象
        Bread bread = new Bread();
        Producer producer = new Producer("生产者", bread);
        Consumer consumer = new Consumer("消费者", bread);
        producer.start();
        consumer.start();
    }


    private static class Bread{
         int count;
    }

    private static class Producer extends Thread{

        private Bread mBread;

        public Producer(String name, Bread bread) {
            super(name);
            this.mBread = bread;
        }

        @Override
        public void run() {
            super.run();
            while (true){
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.getMessage();
                }
                synchronized (mBread){
                    if (mBread.count > 0){
                        try {
                            mBread.wait();
                        }catch (Exception e){
                            e.getMessage();
                        }
                    }else{
                        mBread.count +=10;
                        System.out.println("生产了"+mBread.count+"个面包");
                        mBread.notify();
                    }
                }
            }
        }
    }

    private static class Consumer extends Thread{
        private Bread mBread;

        public Consumer(String name, Bread bread) {
            super(name);
            this.mBread = bread;
        }

        @Override
        public void run() {
            while (true){
                synchronized (mBread){
                    if (mBread.count == 0) {
                        try {
                            mBread.wait();
                        }catch (Exception e){
                            e.getMessage();
                        }
                    }else{
                        try{
                            while (mBread.count>0){
                                System.out.println("消费了第 "+(--mBread.count)+"个面包");
                                Thread.sleep(1000);
                            }
                            mBread.notify();
                        }catch (Exception e){
                            e.getMessage();
                        }
                    }
                }
            }
        }
    }
}
