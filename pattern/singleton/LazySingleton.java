package singleton;

/**
 * 线程不安全的懒汉式单例
 * Created by zfz on 2017/10/24.
 */
public class LazySingleton {

    private static LazySingleton lazySingleton=null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance(){
        if (lazySingleton ==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
