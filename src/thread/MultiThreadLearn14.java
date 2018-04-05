package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个生产者和多个消费者模式
 * <p>
 * 需要考虑使用两个对象锁来实现
 * <p>
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn14 {

    private static class Product {
        public String uid;

        public Product(String uid) {
            this.uid = uid;
        }
    }

    private static final int MAX_PRODUCE_ABILITY = 20;
    private static final Object productLock = new Object();
    private static final Object consumerLock = new Object();

    private static class ProduceThread extends Thread {
        private List<Product> productList;

        public ProduceThread(String name, List<Product> productList) {
            super(name);
            this.productList = productList;
        }

        @Override
        public void run() {
            super.run();
            try {
                while (true) {
                    Thread.sleep(3000);
                    synchronized (productLock) {
                        // 食物个数大于0的时候 继续等待
                        if (productList.size() > 0 ) {
                            productLock.wait();
                            System.out.println("生产者 " + Thread.currentThread().getName() + " 结束等待");
                        }
                        int sumNeedProduce = MAX_PRODUCE_ABILITY - productList.size();
                        for (int i = 0; i < sumNeedProduce; i++) {
                            productList.add(new Product("产品ProductID " + i));
                        }
                        System.out.println("生产者" + Thread.currentThread().getName() + "生产了 " + sumNeedProduce + "食品");
                        Thread.sleep(1000 * 6);
                        synchronized (consumerLock) {
                            System.out.println("通知消费者进行消费...");
                            consumerLock.notifyAll();
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }


    private static class ConsumerThread extends Thread {
        private List<Product> productList;

        public ConsumerThread(String name, List<Product> productList) {
            super(name);
            this.productList = productList;
        }

        @Override
        public void run() {
            super.run();
            try {
                while (true) {
                    Thread.sleep(1000);
                    synchronized (consumerLock) {
                        System.out.println(Thread.currentThread().getName() + "判断开始还剩 " + productList.size() + " 个食物 ");
                        if (productList.isEmpty()) {
                            synchronized (productLock) {
                                productLock.notify();
                            }
                            System.out.println("通知生产者进行生产...");
                            consumerLock.wait();
                            System.out.println("消费锁结束等待...");
                        } else {
                            Product product = productList.remove(0);
                            System.out.println(Thread.currentThread().getName() + "消费了食品 " + product.uid);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        ProduceThread produceThread0 = new ProduceThread("小张", productList);
        ConsumerThread consumerThread0 = new ConsumerThread("消费者1", productList);
        ConsumerThread consumerThread1 = new ConsumerThread("消费者2", productList);
        ConsumerThread consumerThread2 = new ConsumerThread("消费者3", productList);
        ConsumerThread consumerThread3 = new ConsumerThread("消费者4", productList);
        produceThread0.start();
        consumerThread0.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }


}
