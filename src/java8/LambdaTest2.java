package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zfz on 2017/2/27.
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
        List<Integer> l = map(Arrays.asList("Chinese", "American", "Japan"), (String s) -> s.length());
        for (Integer i : l) {
            System.out.println("l " + i);
        }
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for (T t : list) {
            R r = f.apply(t);
            result.add(r);
        }
        return result;
    }
}
