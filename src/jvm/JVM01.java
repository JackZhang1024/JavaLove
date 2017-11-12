package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2017/11/15.
 */
public class JVM01 {

    public static void main(String[] args) {

        // JavaĞéÄâ»úÕ»Òç³ö
        //StackOom stackOom = new StackOom();
        //stackOom.stack();

        // Java¶ÑÒç³ö
        HeapOom heapOom = new HeapOom();
        heapOom.heap();
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
