package thread;

import java.util.ArrayList;

/**
 * ThreadLocal ��ѧϰ
 * ThreadLocal ���߳�һ�������ı����̸߳���
 * �����ù��������̶߳����������ʹ�����
 * <p>
 * ˮ�����ϰ���ˮ���Ĺ���
 * <p>
 * get()�����ص�ǰ�߳̿����ľֲ��̱߳�����ֵ��
 * initialValue()�����ص�ǰ�̸߳���ֲ��̱߳����ĳ�ʼֵ��
 * remove()���Ƴ���ǰ�̸߳���ֲ��̱߳�����ֵ��
 * set(T value)��Ϊ��ǰ�߳̿����ľֲ��̱߳�������һ���ض���ֵ
 * <p>
 * ������͵ıȽ���� http://www.importnew.com/14398.html
 * <p>
 * ThreadLocal ʹ�ò���һ���Ϊ������
 * 1.����һ�� ThreadLocal ���� threadXxx�����������̼߳���Ҫ���봦��Ķ��� xxx��
 * 2.�ṩһ����ȡҪ������ʵ����ݵķ��� getXxx()���ڷ������жϣ��� ThreadLocal����Ϊnullʱ��
 * Ӧ�� new() һ������������͵Ķ���
 * 3.���߳����run()�����У�ͨ��getXxx()������ȡҪ���������ݣ�
 * �������Ա�֤ÿ���̶߳�Ӧһ�����ݶ������κ�ʱ�̶���������������󣬲��ύ�档
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
        Boss boss1 = new Boss("С��", basket);
        Boss boss2 = new Boss("С��", basket);
        boss1.start();
        boss2.start();
    }

    private static void sellFruitsByThreadLocal() {
        BossThreadLocal boss3 = new BossThreadLocal("С��");
        BossThreadLocal boss4 = new BossThreadLocal("С��");
        boss3.start();
        boss4.start();
    }

    static class Basket {

        private ArrayList<String> fruits = new ArrayList<>();

        public Basket() {
            fruits.add("ƻ��");
            fruits.add("��");
            fruits.add("�㽶");
            fruits.add("����");
            fruits.add("����");
        }

        public void addFruit(String fruit) {
            fruits.add(fruit);
        }

        public void sell() {
            while (!fruits.isEmpty()) {
                String fruit = fruits.remove(0);
                System.out.println(Thread.currentThread().getName() + "����ˮ�� " + fruit);
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

    // ��鲻��new ����ʹ��get()������Ŀ�������ö��������¿����µ��ڴ�ռ���
    private static Basket getBasket() {
        Basket basket = basketThreadLocal.get();
        if (basket == null) {
            basket = new Basket();
            basket.addFruit("����");
            basket.addFruit("��֦");
            basketThreadLocal.set(basket);
        }
        return basket;
    }

}
