package java8.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * 缩减操作
 *
 * 基于流中的元素返回结果
 * 缩减操作的就是将一个流缩减成一个值的操作
 * max()和min() count() 都是缩减操作
 *
 * 流基于泛化概念，提供reduce()方法。通过
 * reduce()操作，可以基于任意条件，从流中返回一个值。
 * 根据定义，所有缩减操作都是终端操作。
 *
 * Created by zfz on 2017/11/11.
 */
public class Stream02 {

    public static void main(String[] args) {

        // 创建一个列表
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        // 进行缩减操作

        // 第一种缩减操作
        Optional<Integer> productObj = myList.stream().reduce((a, b)-> a*b);
        if (productObj.isPresent()){
            System.out.println("Product as optional:  "+productObj.get());
        }

        // 第二种缩减操作 identity是单位值的意思
        // 累计函数是乘法的时候 identity是1
        // 累计函数是加法的时候 identity是0
        // reduce() 参数中 a表示的是累计结果中当前的值 b 表示的是流中下一个元素
        int product = myList.stream().reduce(1, (a, b)->a*b);
        System.out.println("Product as int:  "+product);

        // 计算列表中偶数的乘积
        int product1 = myList.stream().reduce(1, (a, b)->{
            if (b%2==0) return a*b;
            else return a;
        });
        System.out.println("列表中偶数的乘积 "+product1);

        int product2 = myList.stream().reduce(0, (a, b)->a+b);
        System.out.println("Product as int:  "+product2);

    }


}
