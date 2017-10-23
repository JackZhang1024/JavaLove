package singleton;

/**
 * 线程安全的懒汉式单例
 * Created by zfz on 2017/10/24.
 */
public class ThreadSafeLazySingleton {

    private static ThreadSafeLazySingleton lazySingleton=null;

    private ThreadSafeLazySingleton() {

    }

    public static synchronized ThreadSafeLazySingleton getInstance(){
        if (lazySingleton ==null){
            lazySingleton = new ThreadSafeLazySingleton();
        }
        return lazySingleton;
    }
}
