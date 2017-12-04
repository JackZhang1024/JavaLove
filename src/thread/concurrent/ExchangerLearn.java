package thread.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 简化两个线程之间的数据交换
 * exchange()方法直到被两个线程都调用之后 才会成功返回
 * 因此, exchange()方法可以同步数据的交换
 * Created by zfz on 2017/12/4.
 */
public class ExchangerLearn {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Producer(exchanger);
        new Consumer(exchanger);
    }

    // 生产者
    static class Producer implements Runnable {
        private Exchanger<String> mExchanger;
        private String[] fruits = new String[]{"苹果", "梨", "橘子", "草莓"};

        public Producer(Exchanger<String> mExchanger) {
            this.mExchanger = mExchanger;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                for (int index = 0; index < fruits.length; index++) {
                    String fruit = fruits[index];
                    System.out.println("producer put " + fruit);
                    mExchanger.exchange(fruit);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {
        private Exchanger<String> mExchanger;

        public Consumer(Exchanger<String> mExchanger) {
            this.mExchanger = mExchanger;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                for (int index = 0; index < 4; index++) {
                    String result = mExchanger.exchange(new String()); // 用空字符串来替换满字符串
                    System.out.println("Consumer Got " + result);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
