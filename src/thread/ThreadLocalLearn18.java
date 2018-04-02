package thread;

import java.util.ArrayList;

/**
 * ThreadLocal 的学习
 * ThreadLocal 给多个线程访问同一个ThreadLocal，存取同一数据类型的不同对象
 * 各个线程之间的没有获取的数据之间没有联系
 * <p>
 * <p>
 * set(T value)：为当前线程存入一个变量
 * get()：返回当前线程set()方法设置的变量。
 * initialValue()：在get()方法执行时，如果发现存入的数据为null, 如果初始化过，即执行过initialValue()
 * 方法，则返回初始化的数据。
 * remove()：移除当前线程设置的ThreadLocal变量的值。
 * <p>
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
public class ThreadLocalLearn18 {


    private static ThreadLocal<Basket> basketThreadLocal = new ThreadLocal<Basket>(){
        @Override
        protected Basket initialValue() {
            // 设置默认的返回数据
            Basket basket = new Basket();
            basket.addFruit("哈密瓜");
            return basket;
        }
    };

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.addFruit("苹果");
        // 设置绑定主线程的数据
        basketThreadLocal.set(basket);
        sellFruitsByThreadLocal();
    }

    private static void sellFruitsByThreadLocal() {
        BossThreadLocal boss3 = new BossThreadLocal("xiaoli");
        BossThreadLocal boss4 = new BossThreadLocal("xiaozhang");
        boss3.start();
        boss4.start();
        basketThreadLocal.get().sell();
    }


    static class Basket {

        private ArrayList<String> fruits = new ArrayList<>();

        public Basket() {

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

    static class BossThreadLocal extends Thread {
        private String name;

        public BossThreadLocal(String name) {
            super(name);
            // 在这块进行初始化 依然是在主线程中
            // 所以不能在这块对ThreadLocal进行数据设置
            this.name = name;
        }

        @Override
        public void run() {
            super.run();
            if ("xiaoli".equalsIgnoreCase(name)){
                Basket basket = new Basket();
                basket.addFruit("梨");
                // 设置绑定xiaoli线程的数据
                basketThreadLocal.set(basket);
            }else if ("xiaozhang".equalsIgnoreCase(name)){
                Basket basket = new Basket();
                basket.addFruit("桃");
                basket.addFruit("橘子");
                // 设置绑定xiaozhang线程的数据
                basketThreadLocal.set(basket);
            }
            basketThreadLocal.get().sell();
        }
    }

}
