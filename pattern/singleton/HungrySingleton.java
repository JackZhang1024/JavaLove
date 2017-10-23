package singleton;

/**
 * 恶汉式单例
 * Created by zfz on 2017/10/24.
 */
public class HungrySingleton {

    private static final  HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

}
