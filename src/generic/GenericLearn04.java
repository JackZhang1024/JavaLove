package generic;

/**
 * 泛型接口
 * <p>
 * 一般情况下，实现了泛型接口，这个类必须是泛型类，而泛型类必须带有将要传递给泛型接口的类型参数
 * public class MyGenType<T> implements MinMax<T>{} 正确
 * public class MyGneType implements MinMax<T> 错误 因为没有给MyGenType声明类型参数，所以无法给MinMax接口传递类型参数
 * 对于这种情况，标识符T是未知的，编译器会报错
 * public class MyGenType implements MinMax<Integer> 正确
 * 如果某个类实现了具有具体类型的泛型接口 那么实现类就不需要进行泛型化
 * <p>
 * 泛型接口具有的两个优势：
 * 1. 可以针对不同的数据类型进行接口实现
 * 2. 可以对实现接口的数据类型进行限制
 * <p>
 * 泛型接口通用语法：
 * interface interface-name<type-param-list>{}
 * type-param-list是由逗号分隔的类型参数列表
 * 当实现泛型接口时，必须指定类型参数
 * class class-name<type-param-list> implements interface-name<type-ara-list>
 * <p>
 * Created by zfz on 2017/12/8.
 */
public class GenericLearn04 {

    public static void main(String[] args) {
        Integer[] values = new Integer[]{1, 2, 3, 4};
        MyMinMax<Integer> myMinMax1 = new MyMinMax<Integer>(values);
        System.out.println("MinVal " + myMinMax1.min());
        System.out.println("MaxVal " + myMinMax1.max());

        String[] values2 = new String[]{"zx", "yu", "dz", "ac"};
        MyMinMax<String> myMinMax2 = new MyMinMax<>(values2);
        System.out.println("MinValStr " + myMinMax2.min());
        System.out.println("MaxValStr " + myMinMax2.max());

        Integer[] values3= new Integer[]{1, 2, 3, 6, 3};
        MyIntegerMinMax myIntegerMinMax = new MyIntegerMinMax(values3);
        System.out.println("MinValInteger "+myIntegerMinMax.min());
        System.out.println("MaxValInteger "+myIntegerMinMax.max());

    }

    //泛型接口是指的是在接口的命名处后面加上类型参数
    //Comparable是类型参数的上界 Comparable指定了将要进行比较的对象类型是实现Comparable接口
    public interface MinMax<T extends Comparable<T>> {
        T min();

        T max();
    }

    //泛型接口实现类的命名是从左向右看的
    //MyMinMax实现了MinMax接口 MyMinMax类传递给MinMax接口的类型参数T
    //而MinMax泛型接口参数T是实现了Comparable接口
    //所以泛型类MyMinMax的类型参数T必须实现Comparable接口
    //而一旦泛型类的类型参数确定之后 就不需要在implements子句中进行指定
    //一旦确定了类型参数 就可以不加修改的传递给接口
    public static class MyMinMax<T extends Comparable<T>> implements MinMax<T> {
        private T[] values;

        public MyMinMax(T[] values) {
            this.values = values;
        }

        @Override
        public T min() {
            T minVal = values[0];
            for (int index = 1; index < values.length; index++) {
                if (values[index].compareTo(minVal) < 0) {
                    minVal = values[index];
                }
            }
            return minVal;
        }

        @Override
        public T max() {
            T maxVal = values[0];
            for (int index = 1; index < values.length; index++) {
                if (values[index].compareTo(maxVal) > 0) {
                    maxVal = values[index];
                }
            }
            return maxVal;
        }
    }


    public static class MyIntegerMinMax implements MinMax<Integer> {
        private Integer[] values ;

        public MyIntegerMinMax(Integer[] vals) {
            this.values = vals;
        }

        @Override
        public Integer min() {
            Integer minVal = values[0];
            for (int index = 1; index < values.length; index++) {
                if (values[index].compareTo(minVal) < 0) {
                    minVal = values[index];
                }
            }
            return minVal;
        }

        @Override
        public Integer max() {
            Integer maxVal = values[0];
            for (int index = 1; index < values.length; index++) {
                if (values[index].compareTo(maxVal) > 0) {
                    maxVal = values[index];
                }
            }
            return maxVal;
        }
    }


}
