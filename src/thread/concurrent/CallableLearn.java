package thread.concurrent;

import java.util.concurrent.*;

/**
 * interface Callable<V> 接口
 * 包含有方法 V call() throws Exception
 * call()使用于有返回值的任务 如果没有任务 则抛出异常
 * Callable任务是通过调用ExecutorService的submit()方法进行执行
 * 返回结果是是一个Future<T>对象， 通过Future对象的get()方法可以获得
 * Callable任务返回的结果
 * <p>
 * <p>
 * Created by zfz on 2017/12/5.
 */
public class CallableLearn {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> plusFuture = executorService.submit(new PlusTask(20));
        Future<Integer> multiFuture = executorService.submit(new MultiplicationTask(20));
        try {
            // get()方法会一直等待
             System.out.println("PlusResult " + plusFuture.get());
            // get(int time, TimeUnit unit) 方法会等待指定的时间 如果没有完成 则会抛出超时异常
            //System.out.println("PlusResult "  + plusFuture.get(6, TimeUnit.SECONDS));
            System.out.println("MultiResult " + multiFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Done ");
    }

    static class PlusTask implements Callable<Integer> {

        private Integer mMaxValue;

        public PlusTask(Integer mMaxValue) {
            this.mMaxValue = mMaxValue;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int index = 0; index < mMaxValue; index++) {
                sum += index;
                Thread.sleep(1000);
            }
            return sum;
        }
    }

    static class MultiplicationTask implements Callable<Integer> {

        private Integer mMaxValue;

        public MultiplicationTask(Integer mMaxValue) {
            this.mMaxValue = mMaxValue;
        }


        @Override
        public Integer call() throws Exception {
            int accumulator = 1;
            for (int index = 1; index < mMaxValue; index++) {
                accumulator *= index;
            }
            return accumulator;
        }
    }


}
