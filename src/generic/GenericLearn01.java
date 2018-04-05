package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 泛型的学习
 * extends 表示的泛型的上限 表示T 继承或者实现接口T
 * super 表示泛型的下限 表示泛型是自身或者是T的父类
 *
 * 泛型方法并不一定出现在泛型类中 普通类中也可以出现
 *
 * Created by zfz on 2017/5/30.
 */
public class GenericLearn01 {

    //第一种排序方式
    // <T extends Comparable<T>> 是泛型参数列表 泛型参数列表在返回值的前面
    public static <T extends Comparable<T>> List<T> mySortFunction(List<T> list) {
        Collections.sort(list);
        return list;
    }

    public static <T extends Comparable<? super T>> List<T> mySortFunction2(List<T> list) {
        Collections.sort(list);
        return list;
    }


    //第二种排序方式

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(20));
        animals.add(new Dog(14));


        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(10));
        dogs.add(new Dog(2));

        //animals = mySortFunction(animals);

        //mySortFunction(dogs)方法不能执行 类型不兼容
        //mySortFunction(dogs);

        mySortFunction2(dogs);

        //mySortFunction2(animals);
        for (Animal animal : animals) {
            System.out.println(" age " + animal.age);
        }
    }

    static class Animal implements Comparable<Animal> {

        public int age;

        public Animal(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Animal o) {
            return this.age - o.age;
        }
    }

    static class Dog extends Animal {

        public Dog(int age) {
            super(age);
        }
    }

}
