package thread;

/**
 * https://www.toutiao.com/i6476014517586231822/
 * 三个线程 轮流打印 A B C
 * http://www.cnblogs.com/jyx140521/p/6747750.html
 * Created by zfz on 2017/11/16.
 */
public class MultiThreadLearn17 {

    public static void main(String[] args) {
        PrintManger printManger = new PrintManger();
        printManger.setPrintA(true);
        printManger.setPrintB(false);
        printManger.setPrintC(false);
        Thread threadA = new ThreadA(printManger);
        Thread threadB = new ThreadB(printManger);
        Thread threadC = new ThreadC(printManger);
        threadA.start();
        threadB.start();
        threadC.start();
    }


    static class PrintManger {
        private boolean printA;
        private boolean printB;
        private boolean printC;

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

        public boolean isPrintC() {
            return printC;
        }

        public void setPrintC(boolean printC) {
            this.printC = printC;
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
                        while (!printManger.isPrintA()) {
                            printManger.wait(); // wait()方法 释放占有的锁
                        }
                        System.out.println("print A ");
                        Thread.sleep(2000);
                        printManger.setPrintA(false);
                        printManger.setPrintB(true);
                        printManger.setPrintC(false);
                        printManger.notifyAll();
                        // 这里使用while是为了多次检测是否打印A
                        // 因为在notifyAll()是 线程A也有可能先于线程B拿到锁 继续进入线程A
                        // 在wait()释放锁之后 线程B可能拿到锁 打印B 释放锁 此时 notifyAll时
                        // 就会打印 A 因为A已经不再检查是否符合打印A的条件
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
                        while (!printManger.isPrintB()) {
                            printManger.wait();
                        }
                        System.out.println("print B ");
                        Thread.sleep(2000);
                        printManger.setPrintB(false);
                        printManger.setPrintA(false);
                        printManger.setPrintC(true);
                        printManger.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class ThreadC extends Thread {
        private final PrintManger printManger;

        public ThreadC(PrintManger printManger) {
            this.printManger = printManger;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (printManger) {
                    try {
                        while (!printManger.isPrintC()) {
                            printManger.wait();
                        }
                        System.out.println("print C ");
                        Thread.sleep(2000);
                        printManger.setPrintB(false);
                        printManger.setPrintC(false);
                        printManger.setPrintA(true);
                        printManger.notifyAll();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


}
