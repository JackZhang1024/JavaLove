package thread.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Fork/Join 并行编程类和接口
 * <p>
 * ForkJoinPool 管理ForkJoinTask
 * ForkJoinTask 抽象类 任务的轻量级抽象
 * RecursiveAction 没有返回值的任务
 * RecursiveTask 有返回值的任务
 * <p>
 * Created by zfz on 2017/12/1.
 */
public class ForkJoinLearn01 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++){
             nums[i] = i;
        }
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        forkJoinPool.invoke(task);
        for(int i=0; i< nums.length; i++){
            double data = nums[i];
            System.out.format("%d %.4f\n", i, data);
        }
    }

    static class SqrtTransform extends RecursiveAction {

        int seqThreshold;
        double[] data;
        int start, end;

        public SqrtTransform(double[] data, int start, int end) {
            this.seqThreshold = 1000;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < seqThreshold) {
                for (int i = start; i < end; i++) {
                    data[i] = Math.sqrt(data[i]);
                }
            } else {
                int middle = (start + end) / 2;
                invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
            }
        }
    }


}
