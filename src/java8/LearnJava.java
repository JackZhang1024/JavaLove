package java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2017/2/26.
 */


public class LearnJava{
    private static List<Apple> appleList = new ArrayList<>();

    public static void main(String[] args) {
        appleList.add(new Apple("red",20));
        appleList.add(new Apple("red",20));
        appleList.add(new Apple("green",120));
        appleList.add(new Apple("green",70));
        //注意："red".equals(apple.getColor())方法是test接口方法的实现
        //1.挑选出颜色是绿色的苹果
        //List<Apple> apples=applePredicate(appleList,(Apple apple)->"red".equals(apple.getColor()));
        //2.给苹果的重量做出排序
//        List<Apple> apples=appleList.sort(
//                (Apple apple1,Apple apple2)->
//                        apple1.getHeavyWeight().compareTo(apple2.getHeavyWeight()));

         Thread t=new Thread(()-> System.out.println("hello world"));
         t.start();
//        for (Apple apple:apples){
//            System.out.println("Apple color "+apple.getColor()+" weight "+apple.getHeavyWeight());
//        }

    }

    public static <T> List<T> applePredicate(List<T> list,Predicate<T> p){
        List<T> resultList=new ArrayList<T>();
        for(T t:list){
            if(p.test(t)){
               resultList.add(t);
            }
        }
        return resultList;
    }

}
