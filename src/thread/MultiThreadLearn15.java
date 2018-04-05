package thread;

/**
 * 多个生产者和多个消费者模式
 * https://www.cnblogs.com/shuqingstudy/p/5057787.html
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn15 {

    private static final int MAX_PRODUCE_ABILITY = 5;

    private static class Product {
        private boolean isConsume = false;
        private int count;

        public synchronized void set() {
            try {
                // 如果正在消费 进行等待
                while (isConsume) {
                    try {
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 每次生产5个产品
                count+=5;
                isConsume = true;
                Thread.sleep(1000);
                System.out.println("生产者 " + Thread.currentThread().getName() + " " + count + " 产品");
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public synchronized void out() {
            try {
                // 如果线程正在进行生产 进行等待
                while (!isConsume) {
                    try {
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Thread.sleep(2000);
                while (count>0) {
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 消费后剩余 " + count + "个产品");
                }
                isConsume = false;
                this.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // 生产者
    private static class Producer implements Runnable {
        private Product product;

        public Producer(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (true) {
                product.set();
            }
        }
    }


    // 消费者
    private static class Consumer implements Runnable {
        private Product product;

        public Consumer(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            while (true) {
                product.out();
            }
        }
    }

    public static void main(String[] args) {
        Product product = new Product();

        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        Thread producer1 = new Thread(producer);
        Thread producer2 = new Thread(producer);

        Thread consumer1 = new Thread(consumer);
        Thread consumer2 = new Thread(consumer);

        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();

    }


}
