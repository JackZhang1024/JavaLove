package generic;

/**
 * 使用泛型的好处
 * 1. 不用考虑类型转换的问题 有类型转换问题在编译阶段就会报错
 * 2. 使用泛型可以满足算法的普遍性 也就是说一种算法可以在多种数据类型下使用
 *
 * Created by zfz on 2017/12/8.
 */
public class GenericLearn02 {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 6};
        System.out.println(isIn(1, nums));

        String[] values = new String[]{"1", "2", "3", "4"};
        System.out.println(isIn("2", values));
    }

    public static <T extends Comparable<T>, V extends T> boolean isIn(T t, V[] v){
        for (V value: v){
             if(value.equals(t)){
                return true;
             }
        }
        return false;
    }



}
