package thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic
 * Created by zfz on 2017/12/3.
 */

public class MultiThreadLearn20 {

    public static void main(String[] args) {
        ExecutorService service =
                Executors.newFixedThreadPool(Integer.MAX_VALUE);
        final CJTest cjTest = new CJTest();
        final CJTest2 cjTest2 = new CJTest2();
        final CJTest3 cjTest3 = new CJTest3();
        for (int index = 0; index < 2000; index++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    //cjTest.increase();
                    //cjTest2.increase();
                    //cjTest2.increase2();
                    //cjTest2.increase3();
                    cjTest3.increase();
                }
            });
        }
        service.shutdown();
        //System.out.println("Result: CJTest.count = "+CJTest.count);
        //System.out.println("Result: CJTest2.count = "+CJTest2.count);
        System.out.println("Result: CJTest2.count = " + CJTest3.count);
    }

    public static class CJTest {

        //public volatile static int count = 0;
        public static AtomicInteger count = new AtomicInteger(0);

        public void increase() {
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //count++;
            count.getAndIncrement(); // 这个结果是对的
        }
    }

    public static class CJTest2 {
        public static int count = 0;

        //synchronized修饰非static方法时，
        //是锁住this，也就是对象本身，
        //synchronized修改static方法时，锁住的是类
        public synchronized void increase() {
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "increase " + count);
        }

        public static synchronized void increase2() {
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "increase2 " + count);
        }

        public synchronized void increase3() {
            try {
                Thread.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "increase3 " + count);
        }

    }


    public static class CJTest3 {

        public static int count = 0;
        private static Object lock = new Object();

        public void increase() {
            synchronized (lock) {
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("CJTest3 " + count);
            }
        }
    }


}
