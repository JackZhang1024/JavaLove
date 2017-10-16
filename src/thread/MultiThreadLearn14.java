package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个生产者和多个消费者模式
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
    private static boolean isProduce = true;

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
                Thread.sleep(3000);
            }catch (Exception e){
                e.getMessage();
            }
            while (true) {
                synchronized (productList) {
                    if (productList.size() == MAX_PRODUCE_ABILITY) {
                        try {
                            productList.wait();
                            System.out.println("生产者 " + Thread.currentThread().getName() + " 结束等待");
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    if (!isProduce) return;
                    int sumNeedProduce = MAX_PRODUCE_ABILITY - productList.size();
                    for (int i = 0; i < sumNeedProduce; i++) {
                        productList.add(new Product("ProductID " + i));
                    }
                    System.out.println("生产者" + Thread.currentThread().getName() + "生产了 " + sumNeedProduce + "食品");
                    try {
                        Thread.sleep(100); // 模拟生产过程
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    isProduce = false;
                    productList.notifyAll(); // 通知消费者消费
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
                    System.out.println(Thread.currentThread().getName()+ "判断开始 "+productList.size()+" 食物 ");
                    if (productList.isEmpty()) {
                        try {
                            System.out.println(Thread.currentThread().getName()+ "消费者等待开始");
                            productList.wait();
                            System.out.println(Thread.currentThread().getName()+ "消费者等待结束");
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                    if (!productList.isEmpty()){
                        Product product = productList.remove(0);
                        System.out.println(Thread.currentThread().getName() + "消费了食品 " + product.uid);
                    }
                    if (productList.isEmpty()) {
                        isProduce = true;
                        System.out.println(Thread.currentThread().getName()+ "通知生产者生产");
                        productList.notifyAll();
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
