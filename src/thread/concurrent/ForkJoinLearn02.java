package thread.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by zfz on 2017/12/5.
 */
public class ForkJoinLearn02 {

    public static void main(String[] args) {
        int pLevel;
        int threshold;
        System.out.println("processors " + Runtime.getRuntime().availableProcessors());
        if (args.length != 2) {
            System.out.println("Usage: ");
            //return;
        }
        //pLevel = Integer.parseInt(args[0]);
        //threshold = Integer.parseInt(args[1]);
        pLevel = 1;
        threshold = 1000;
        long beginT, endT;
        ForkJoinPool forkJoinPool = new ForkJoinPool(pLevel);
        double[] nums = new double[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        forkJoinPool.invoke(task);
        endT = System.nanoTime();
        System.out.println("Level of parallelism " + pLevel);
        System.out.println("Sequential threshold " + threshold);
        System.out.println("Elpased Time  " + (endT - beginT) + " ns");
    }

    static class SqrtTransform extends RecursiveAction {

        int seqThreshold;
        double[] data;
        int start, end;

        public SqrtTransform(double[] data, int start, int end, int threshold) {
            this.data = data;
            this.start = start;
            this.end = end;
            this.seqThreshold = threshold;
        }

        @Override
        protected void compute() {
            if (end - start < seqThreshold) {
                for (int i = start; i < end; i++) {
                    if (i % 2 == 0) {
                        data[i] = Math.sqrt(data[i]);
                    } else {
                        data[i] = Math.cbrt(data[i]);
                    }
                }
            } else {
                int middle = (start + end) / 2;
                invokeAll(new ForkJoinLearn01.SqrtTransform(data, start, middle), new ForkJoinLearn01.SqrtTransform(data, middle, end));
            }
        }
    }

}
