package thread.threadpool;

/**
 * 线程池的学习
 *
 * 使用线程池的目的
 *
 * 1. 重复创建Thread会造成大量的系统资源消耗
 * 2. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom
 * 3. 直接创建Thread不便于管理 无法进行定时执行 定期执行 线程中断
 *
 * 使用线程池的好处
 * 1. 重用存在的线程，减少对象创建，消亡的开销，性能佳
 * 2. 可有效控制最大并发线程数， 提高系统资源的使用率， 同时避免过多资源竞争，避免阻塞。
 * 3. 提供定时执行， 定期执行，单线程， 并发数控制等功能。
 *
 * Java线程池：
 * Java通过Executors提供四种线程池，分别为：
 * 1. newCachedThreadPool ： 创建一个可缓存的线程池， 如果线程池中的线程数量超过处理需求，可灵活回收空线程，若无可回收，则创建新的线程
 * 2. newFixedThreadPool : 创建一个线程数量固定的线程池， 可控制线程的最大并发数， 超过的线程会在队列中等待。
 * 3. newScheduleThreadPool : 创建一个定长的线程池， 支持定时及周期性任务执行
 * 4. newSingleThreadPool : 创建一个单线程的线程池， 它只会用唯一的工作线程来执行任务，保证所有任务按照指定的顺序执行(FIFO, LIFO, 优先级)执行
 *
 * Created by zfz on 2018/4/2.
 */
public class ThreadPoolLearn023 {

    public static void main(String[] args) {



    }


}
