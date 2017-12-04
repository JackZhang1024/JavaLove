package thread.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 使用两个信号量对生产者和消费者线程进行管理
 * <p>
 * 从结果上我们可以看到get()和put()方法是同步的
 * put()方法执行在get()方法之前
 * 执行get()方法的时候 我们必须从ConsumeSemaphore获取许可证，不让无法继续执行
 * 在获取到ConsumeSemaphore许可证之后，我们执行消费操作，然后我们释放ProducerSemaphore许可证
 * 这样put()方法就可以继续执行
 *
 * 执行put()方法 我们先要从ProducerSemaphore许可证 然后执行put()操作，执行完成后
 * 释放ConsumerSemaphore许可证 这样get()方法就可以继续执行
 *
 * 这样的"给予获取"机制确保了在每次put()之后，都会有get()方法紧跟着执行
 *
 * ConsumeSemaphore初始化未没有许可证，保证了put()方法先执行。
 * 信号量可以初始化同步状态是信号量更为强大的一方面。
 *
 *
 * <p>
 * Created by zfz on 2017/12/4.
 */
public class SemaphoreLearn02 {


    public static void main(String[] args) {
        Plate plate = new Plate();
        new Thread(new Consumer(plate));
        new Thread(new Producer(plate));
    }

    static class Plate {
        private int num;
        private Semaphore mConsumerSemaphore = new Semaphore(0); // 参数为0表示没有获取到信号量的许可证
        private Semaphore mProducerSemaphore = new Semaphore(1);

        public void get() {
            try {
                mConsumerSemaphore.acquire();
                Thread.sleep(1000);
                System.out.println("Plate consume Num " + num);
                mProducerSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void put(int num) {
            try {
                mProducerSemaphore.acquire();
                this.num = num;
                Thread.sleep(1000);
                System.out.println("Plate produce Num " + num);
                mConsumerSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    static class Consumer implements Runnable {
        private Plate mPlate;

        public Consumer(Plate mPlate) {
            this.mPlate = mPlate;
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int index = 0; index < 20; index++) {
                mPlate.get();
            }
        }
    }

    // 生产者
    static class Producer implements Runnable {
        private Plate mPlate;

        public Producer(Plate mPlate) {
            this.mPlate = mPlate;
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int index = 0; index < 20; index++) {
                mPlate.put(index);
            }
        }
    }

}
