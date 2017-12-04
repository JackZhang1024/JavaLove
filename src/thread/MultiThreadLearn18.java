package thread;

import java.util.ArrayList;

/**
 * ThreadLocal 的学习
 * ThreadLocal 给线程一个变量的本地线程副本
 * 而不用关心其他线程对这个变量的使用情况
 * <p>
 * 水果店老板卖水果的故事
 * <p>
 * get()：返回当前线程拷贝的局部线程变量的值。
 * initialValue()：返回当前线程赋予局部线程变量的初始值。
 * remove()：移除当前线程赋予局部线程变量的值。
 * set(T value)：为当前线程拷贝的局部线程变量设置一个特定的值
 * <p>
 * 这个解释的比较清楚 http://www.importnew.com/14398.html
 * <p>
 * ThreadLocal 使用步骤一般分为三步：
 * 1.创建一个 ThreadLocal 对象 threadXxx，用来保存线程间需要隔离处理的对象 xxx；
 * 2.提供一个获取要隔离访问的数据的方法 getXxx()，在方法中判断，若 ThreadLocal对象为null时候，
 * 应该 new() 一个隔离访问类型的对象；
 * 3.在线程类的run()方法中，通过getXxx()方法获取要操作的数据，
 * 这样可以保证每个线程对应一个数据对象，在任何时刻都操作的是这个对象，不会交叉。
 * <p>
 * <p>
 * Created by zfz on 2017/11/25.
 */
public class MultiThreadLearn18 {

    public static void main(String[] args) {
        //sellFruits();
        sellFruitsByThreadLocal();
    }

    private static void sellFruits() {
        Basket basket = new Basket();
        Boss boss1 = new Boss("小李", basket);
        Boss boss2 = new Boss("小张", basket);
        boss1.start();
        boss2.start();
    }

    private static void sellFruitsByThreadLocal() {
        BossThreadLocal boss3 = new BossThreadLocal("小李");
        BossThreadLocal boss4 = new BossThreadLocal("小张");
        boss3.start();
        boss4.start();
    }

    static class Basket {

        private ArrayList<String> fruits = new ArrayList<>();

        public Basket() {
            fruits.add("苹果");
            fruits.add("梨");
            fruits.add("橘子");
            fruits.add("香蕉");
            fruits.add("草莓");
        }

        public void addFruit(String fruit) {
            fruits.add(fruit);
        }

        public void sell() {
            while (!fruits.isEmpty()) {
                String fruit = fruits.remove(0);
                System.out.println(Thread.currentThread().getName() + "卖出 " + fruit);
            }
        }
    }


    static class Boss extends Thread {
        private Basket basket;
        private String name;

        public Boss(String name, Basket basket) {
            super(name);
            this.basket = basket;
        }

        @Override
        public void run() {
            super.run();
            basket.sell();
        }
    }

    static class BossThreadLocal extends Thread {
        private String name;

        public BossThreadLocal(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 2; i++) {
                Basket basket = getBasket();
                basket.sell();
            }
        }
    }

    private static ThreadLocal<Basket> basketThreadLocal = new ThreadLocal<>();

    private static Basket getBasket() {
        Basket basket = basketThreadLocal.get();
        if (basket == null) {
            basket = new Basket();
            basket.addFruit("猕猴桃");
            basket.addFruit("西瓜");
            basketThreadLocal.set(basket);
        }
        return basket;
    }

}
