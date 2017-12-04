package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2017/11/15.
 */
public class JVM01 {

    public static void main(String[] args) {

        // JavaÐéÄâ»úÕ»Òç³ö
        //StackOom stackOom = new StackOom();
        //stackOom.stack();

        // Java¶ÑÒç³ö
        //HeapOom heapOom = new HeapOom();
        //heapOom.heap();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TotalMemory "+totalMemory/(1024*1024)+" M");
        System.out.println("FreeMemory  "+freeMemory/(1024*1024)+" M");
        System.out.println("MaxMemory "+maxMemory/(1024*1024)+" M");
    }

    public static class StackOom {
        public int num = 1;

        public void stack() {
            num++;
            this.stack();
        }
    }

    public static class HeapOom {
        private List<byte[]> data = new ArrayList<>();

        public void heap() {
            while (true) {
                data.add(new byte[1024*1024]);
            }
        }


    }
}
