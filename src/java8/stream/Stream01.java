package java8.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 流API的关键一点在于能够执行非常复杂的查找、过滤和映射数据等操作
 * 简单来说 流API提供了简单易用的数据处理方式
 *
 * 1. 中间操作 有状态之分 分为 1.有状态 2.无状态
 * 2. 终端操作
 *
 * Created by zfz on 2017/11/11.
 */
public class Stream01 {

    public static void main(String[] args) {

        // 创建一个Integer集合
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Original list: "+myList);

        // 获取这个集合的流
        Stream<Integer> myStream = myList.stream();

        // 获取集合中的最小值
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if (minVal.isPresent()){
            System.out.println("Minimum is "+minVal.get());
        }

        // 由于上边的使用了终端操作stream.min() 导致该流被消费过了
        // 不能再使用 如果想使用流 就必须重新stream()
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent()){
            System.out.println("Maximum is "+maxVal.get());
        }
        System.out.println();

        //对集合进行排序 默认的应该是升序排序
        Stream<Integer> sortedStream = myList.stream().sorted();
        sortedStream.forEach((n)-> System.out.println(n+""));
        System.out.println();

        // 对集合进行过滤操作 获得集合中的奇数
        Stream<Integer> oddVals = myList.stream().sorted()
                .filter(n->n%2 == 1);
        oddVals.forEach(n-> System.out.println(n+""));
        System.out.println();

        // 对集合进行操作 获取集合中大于5的奇数
        oddVals = myList.stream()
                .sorted()
                .filter(n->n%2==1)
                .filter(n->n>5);
        oddVals.forEach(n-> System.out.println(n+""));
        System.out.println();
    }
}
