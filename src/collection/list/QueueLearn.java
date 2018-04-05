package collection.list;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zfz on 2018/4/3.
 */
public class QueueLearn {

    public static void main(String[] args) {
        //testQueue();
        //testQueue2();
        //testQueue3();
        testQueue4();
    }


    // FIFO 先进先出
    private static void testQueue(){
        Queue<String>  stringQueue = new LinkedList<>();
        stringQueue.offer("A");
        stringQueue.offer("B");
        stringQueue.offer("C");

        System.out.println("Peek "+stringQueue.peek());
        System.out.println("Poll  "+stringQueue.poll());
        System.out.println(stringQueue);
        System.out.println("Poll "+stringQueue.poll());
        System.out.println(stringQueue);
        System.out.println("Poll "+stringQueue.poll());
        System.out.println(stringQueue);
    }


    // 单队列
    private static void testQueue2(){
        Deque<String> stringQueue = new LinkedList<>();
        stringQueue.offer("A");
        stringQueue.offer("B");
        System.out.println(" "+stringQueue);
        stringQueue.poll();
        System.out.println(" "+stringQueue);
    }


    // 双头队列
    private static void testQueue3(){
        Deque<String> stringQueue = new LinkedList<>();

        stringQueue.offerFirst("A");
        stringQueue.offerLast("B");
        System.out.println(" "+stringQueue);
        stringQueue.pollFirst();
        System.out.println(" "+stringQueue);
        stringQueue.pollLast();
        System.out.println(" "+stringQueue);

    }

    // 堆栈 先进后出 FILO
    private static void testQueue4(){
        Deque<String> stringQueue = new LinkedList<>();

        stringQueue.push("A");
        stringQueue.push("B");
        stringQueue.push("C");
        stringQueue.push("D");
        System.out.println(" "+stringQueue);
        stringQueue.pop();
        System.out.println(" "+stringQueue);
        stringQueue.pop();
        System.out.println(" "+stringQueue);
        stringQueue.pop();
        System.out.println(" "+stringQueue);
        stringQueue.pop();
        System.out.println(" "+stringQueue);

    }




}
