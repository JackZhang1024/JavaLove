package thread;

/**
 * Created by zfz on 2017/12/21.
 */
public class ThreadLocalLearn19 {

    private static ThreadLocal<String> mNameThreadLoacl = new ThreadLocal<>();
    private static ThreadLocal<String> mValueThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        doSomething();
    }


    private static void doSomething() {
        for (int index=0; index < 10; index++){
            final String name  = "名称 "+index;
            final String value = "值"+ index;
            new Thread(){
                 @Override
                 public void run() {
                     super.run();
                     try {
                         // 注意：这块的name本属于主线程中的，但是因为使用了threadLocal，就将name变量备份了一份到当前线程中
                         // 这样每个线程中都会一个name的变量备份，尽管他们的数据不一样，同理 value变量也是如此
                         // 后面的代码的意思就是说这个变量和线程是绑定了的，只要使用threadLocal的的get()方法就可以取出值来。
                         mNameThreadLoacl.set(name);
                         mValueThreadLocal.set(value);
                         callA();
                     }catch (Exception e){
                         e.printStackTrace();
                     }finally {
                         mNameThreadLoacl.remove();
                         mValueThreadLocal.remove();
                     }
                 }
             }.start();
        }
    }

    private static void callA(){
        callB();
    }

    private static void callB(){
        callC();
    }

    private static void callC(){
        System.out.println("当前线程 "+mNameThreadLoacl.get()+"  "+mValueThreadLocal.get());
    }

}
