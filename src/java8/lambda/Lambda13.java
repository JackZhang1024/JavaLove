package java8.lambda;

import java.util.function.Function;

/**
 * 预定义的函数式接口
 *
 * java.util.function 包中提供的一些预定义的函数式接口
 * 1. UnaryOperator<T>
 *    对类型为 T 的对象应用一元运算， 并返回结果。结果的类型也是T.
 *    包含的方法名为apply()
 *
 * 2. BinaryOperator<T>
 *    对类型为 T 的两个对象进行操作，并返回结果，返回结果的类型也是T.
 *    包含的方法名为apply()
 *
 * 3. Consumer<T>
 *    对类型为T 的对象进行操作。包含的方法名为accept()
 *
 * 4. Supplier<T>
 *    返回类型为 T 的对象。包含的方法名为get()
 *
 * 5. Function<T, R>
 *    对类型为 T的对象引用操作，并返回结果。结果类型为 R的对象。
 *    包含的方法名为 apply()
 *
 * 6. Predicate<T>
 *    确定类型为 T的对象是否满足某种约束，返回的结果是布尔值。
 *    包含的方法名为 test()
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda13 {

    public static void main(String[] args) {
        functionLearn();
    }

    private static void functionLearn(){
        Function<Integer, Integer> function = (n)-> {
            int result = 1;
            for (int i=1; i <= n; i++){
                 result =result*i;
            }
            return result;
        };
        int result = function.apply(4);
        System.out.println("result "+result);
    }


}
