package generic;


/**
 * 通配符 ?
 * 使用
 * Created by zfz on 2017/12/9.
 */
public class GenericLearn07 {

    public static void main(String[] args) {
        Integer[] integerArrays = new Integer[]{10, 12, 13, 14};
        Stats<Integer> integerStats = new Stats<>(integerArrays);

        Double[] doubleArrays = new Double[]{10.0, 11.0, 13.0, 16.0};
        Stats<Double> doubleStats = new Stats<>(doubleArrays);

        System.out.println("isSame " + integerStats.isSame(doubleStats));

        //如果不同的类型参数的泛型类实例之间是不可以比较的
        //但是如果使用的是通配符 则可以突破这种限制
        //System.out.println("isSame2" + integerStats.isSame2(doubleStats));
    }

    public static class Stats<T extends Number> {
        private T[] nums;

        public Stats(T[] nums) {
            this.nums = nums;
        }

        public double average() {
            double sum = 0;
            for (int index = 0; index < nums.length; index++) {
                sum += nums[index].doubleValue();
            }
            return sum;
        }

        //使用通配符实现不同类型的泛型实例相互之间的比较
        public boolean isSame(Stats<?> stats) {
            if (average() == stats.average()) {
                return true;
            }
            return false;
        }

        public boolean isSame2(Stats<T> stats) {
            if (average() == stats.average()) {
                return true;
            }
            return false;
        }
    }


}
