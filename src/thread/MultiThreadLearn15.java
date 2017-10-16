package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 一个生产者和多个消费者模式
 * Created by zfz on 2017/10/15.
 */
public class MultiThreadLearn15 {

    private static class Product {
        public String uid;

        public Product(String uid) {
            this.uid = uid;
        }
    }

    private static final int MAX_PRODUCE_ABILITY = 20;
    private static boolean isStartProduce = true;
    private static boolean isStartConsume = false;

    private static class ProduceThread extends Thread {
        private List<Product> productList;

        public ProduceThread(String name, List<Product> productList) {
            super(name);
            this.productList = productList;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(3000);
                    synchronized (productList) {
                        if (productList.size() == MAX_PRODUCE_ABILITY) {
                            try {
                                isStartProduce = false;
                                isStartConsume = true;
                                productList.notifyAll(); // 通知消费者消费
                                //System.out.println("生产者 " + Thread.currentThread().getName() + " 等待开始");
                                productList.wait();
                                //System.out.println("生产者 " + Thread.currentThread().getName() + " 结束等待");
                            } catch (Exception e) {
                                e.getMessage();
                            }
                        }
                        if (!isStartProduce) continue;
                        int sumNeedProduce = MAX_PRODUCE_ABILITY - productList.size();
                        Random random = new Random();
                        int count = random.nextInt(sumNeedProduce) + 1;
                        for (int i = 0; i < count; i++) {
                            productList.add(new Product("ProductID " + i));
                        }
                        System.out.println("生产者" + Thread.currentThread().getName() + "生产了 " + count + "食品");
                    }
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
            while (true) {
                synchronized (productList) {
                    if (productList.isEmpty()) {
                        try {
                            isStartProduce = true;
                            isStartConsume = false;
                            System.out.println(Thread.currentThread().getName() + "通知生产者生产");
                            productList.notifyAll();
                            //System.out.println(Thread.currentThread().getName() + "消费者等待开始");
                            productList.wait(); // 释放锁 进入等待状态
                            //System.out.println(Thread.currentThread().getName() + "消费者等待结束");
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    if (!isStartConsume) continue;
                    //System.out.println(Thread.currentThread().getName() + "判断开始 " + productList.size() + " 食物 ");
                    if (!productList.isEmpty()) {
                        Product product = productList.remove(0);
                        System.out.println(Thread.currentThread().getName() + "消费了食品 " + product.uid);
                    }
                }
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }


    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        ProduceThread produceThread0 = new ProduceThread("小张", productList);
        ProduceThread produceThread1 = new ProduceThread("小李", productList);
        ProduceThread produceThread2 = new ProduceThread("小王", productList);
        ConsumerThread consumerThread0 = new ConsumerThread("消费者1", productList);
        ConsumerThread consumerThread1 = new ConsumerThread("消费者2", productList);
        ConsumerThread consumerThread2 = new ConsumerThread("消费者3", productList);
        ConsumerThread consumerThread3 = new ConsumerThread("消费者4", productList);
        produceThread0.start();
        produceThread1.start();
        produceThread2.start();
        consumerThread0.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
    }


}
