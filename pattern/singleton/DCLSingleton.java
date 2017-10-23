package singleton;

/**
 * 双重锁检查单例（Doubel-Check Singleton）
 * 使用volatile可以禁止指令重排
 * Created by zfz on 2017/10/24.
 */
public class DCLSingleton {

    private volatile static DCLSingleton dclSingleton = null;

    private DCLSingleton() {

    }

    public static DCLSingleton getInstance() {
        if (dclSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
