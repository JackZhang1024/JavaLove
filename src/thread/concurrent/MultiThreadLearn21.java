package thread.concurrent;

import java.util.concurrent.locks.ReentrantLock;
/**
 * ReentrantLock的学习
 * <p>
 * Lock的一般语法：
 * Lock lock = new ReentrantLock();
 * lock.lock();
 * try{
 * <p>
 * }catch(Exception e){
 * <p>
 * }finally{
 * lock.unlock();
 * }
 * <p>
 * 锁lock分为“公平锁”和“非公平锁”。
 * 1公平锁：表示线程获取锁的顺序是按照线程加锁的顺序来分配的(就是按照启动的顺序来的)，即先来先得FIFO先进先出的顺序。
 * 2非公平锁：就是一种获取锁的抢占机制，是随机获得锁的。和公平锁不一样的就是先来的不一定先得到锁。
 * 这个方式可能造成某些线程一直拿不到锁，结果就是不公平的。
 * <p>
 *
 * synchronized是Java中的关键字，使用synchronized能够防止多个线程同时并发访问程序的临界区资源。
 * synchronized进行同步有四种情况：
 * 第一种：修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 * 第二种：修饰一个方法：被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 * 第三种：修饰一个静态的方法：其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 * 第四种：修饰一个类：其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 3. Lock与synchronized的对比
 1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
 2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；
 而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
 3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
 4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
 5）Lock可以提高多个线程进行读操作的效率。
 在性能上来说，如果竞争资源不激烈，两者的性能是差不多的，而当竞争资源非常激烈时（即有大量线程同时竞争），
 此时Lock的性能要远远优于synchronized。因此，在具体使用时要根据适当情况选择。
 *
 *Created by zfz on 2017/12/4.
 */

public class MultiThreadLearn21 {

    public static void main(String[] args) {
         //testFairReentrantLock();
         testUnFairReentrantLock();
    }

    private static void testFairReentrantLock(){
        for (int index =0; index< 10; index++){
            new Thread(new FairReentrantLock()).start();
        }
    }

    public static class FairReentrantLock implements Runnable {
        private static final ReentrantLock mReentrantLock = new ReentrantLock(true);
        private static int count = 0;

        @Override
        public void run() {
            System.out.println("FairReentrantLock " + Thread.currentThread().getName()+" start");
            try {
                mReentrantLock.lock();
                System.out.println("FairReentrantLock " + Thread.currentThread().getName()+" access lock");
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                mReentrantLock.unlock();
            }
            System.out.println("FairReentrantLock " + Thread.currentThread().getName()+" result "+count);
        }
    }

    private static void testUnFairReentrantLock(){
        for (int index =0; index< 10; index++){
            new Thread(new UnFairReentrantLock()).start();
        }
    }

    public static class UnFairReentrantLock implements Runnable {
        private static final ReentrantLock mReentrantLock = new ReentrantLock(false);
        private static int count = 0;

        @Override
        public void run() {
            System.out.println("UnFairReentrantLock " + Thread.currentThread().getName()+" start");
            try {
                mReentrantLock.lock();
                System.out.println("UnFairReentrantLock " + Thread.currentThread().getName()+" access lock");
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                mReentrantLock.unlock();
            }
            System.out.println("UnFairReentrantLock " + Thread.currentThread().getName()+" result "+count);
        }
    }

}
