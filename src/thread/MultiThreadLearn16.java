package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程轮流打印AB
 * Created by zfz on 2017/11/16.
 */
public class MultiThreadLearn16 {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition aCondition = reentrantLock.newCondition();
    private Condition bCondition = reentrantLock.newCondition();

    public static void main(String[] args) {
        //method1();
        method2();
    }

    public static void method1() {
        PrintManger printManger = new PrintManger();
        printManger.setPrintA(true);
        printManger.setPrintB(false);
        Thread threadA = new ThreadA(printManger);
        Thread threadB = new ThreadB(printManger);
        threadA.start();
        threadB.start();
    }

    public static void method2(){
        MultiThreadLearn16 multiThreadLearn16 = new MultiThreadLearn16();
        A threadA = multiThreadLearn16.new A();
        B threadB = multiThreadLearn16.new B();
        threadA.start();
        threadB.start();
    }


    static class PrintManger {
        private boolean printA;
        private boolean printB;

        public boolean isPrintA() {
            return printA;
        }

        public void setPrintA(boolean printA) {
            this.printA = printA;
        }

        public boolean isPrintB() {
            return printB;
        }

        public void setPrintB(boolean printB) {
            this.printB = printB;
        }
    }

    static class ThreadA extends Thread {
        private final PrintManger printManger;

        public ThreadA(PrintManger printManger) {
            this.printManger = printManger;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (printManger) {
                    try {
                        if (!printManger.isPrintA()) {
                            printManger.wait();
                        }
                        System.out.println("print A ");
                        Thread.sleep(2000);
                        printManger.setPrintB(true);
                        printManger.setPrintA(false);
                        printManger.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class ThreadB extends Thread {
        private final PrintManger printManger;

        public ThreadB(PrintManger printManger) {
            this.printManger = printManger;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (printManger) {
                    try {
                        if (!printManger.isPrintB()) {
                            printManger.wait();
                        }
                        System.out.println("print B ");
                        Thread.sleep(2000);
                        printManger.setPrintA(true);
                        printManger.setPrintB(false);
                        printManger.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class A extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                reentrantLock.lock();
                try {
                    System.out.println("print A");
                    Thread.sleep(1000);
                    bCondition.signal();
                    aCondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }
    }

    class B extends Thread {

        @Override
        public void run() {
            super.run();
            while (true) {
                reentrantLock.lock();
                try {
                    System.out.println("print B");
                    Thread.sleep(1000);
                    aCondition.signal();
                    bCondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }
    }


}
