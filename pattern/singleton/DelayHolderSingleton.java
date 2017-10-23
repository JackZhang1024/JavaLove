package singleton;

/**
 * 延迟初始化占位模式单例 线程安全的
 * Created by zfz on 2017/10/24.
 */
public class DelayHolderSingleton {

    private static DelayHolderSingleton delayHolderSingleton;

    private DelayHolderSingleton(){

    }

    private static class InstanceHolder{
         static DelayHolderSingleton delayHolderSingleton = new DelayHolderSingleton();
    }

    public static DelayHolderSingleton getInstance(){
        return InstanceHolder.delayHolderSingleton;
    }


}
