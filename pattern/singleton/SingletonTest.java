package singleton;

/**
 * Created by zfz on 2017/10/24.
 */
public class SingletonTest {


    public static void main(String[] args) {
        testHungrySingleton();
        testLazySingleton();
        testThreadSafeSingleton();
        testDCLSingleton();
        testDelayHolderSingleton();
    }

    private static void testHungrySingleton(){
        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance();
        System.out.println("singleton1==singleton2  "+(singleton1==singleton2));
    }

    private static void testLazySingleton(){
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println("lazySingleton1==lazySingleton2 "+(lazySingleton1==lazySingleton2));
    }

    private static void testThreadSafeSingleton(){
        ThreadSafeLazySingleton threadSafeLazySingleton1 = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton threadSafeLazySingleton2 = ThreadSafeLazySingleton.getInstance();
        System.out.println("threadSafeSingleton1 == threadSafeSingleton2 "+
                (threadSafeLazySingleton1==threadSafeLazySingleton2));
    }

    private static void testDCLSingleton(){
        DCLSingleton dclSingleton1 = DCLSingleton.getInstance();
        DCLSingleton dclSingleton2 = DCLSingleton.getInstance();
        System.out.println("dclSingleton1 == dclSingleton2 "+(dclSingleton1 == dclSingleton2));
    }

    private static void testDelayHolderSingleton(){
        DelayHolderSingleton delayHolderSingleton1 = DelayHolderSingleton.getInstance();
        DelayHolderSingleton delayHolderSingleton2 = DelayHolderSingleton.getInstance();
        System.out.println("DelayHolderSingleton1 == DelayHolderSingleton2 "+(delayHolderSingleton1==delayHolderSingleton2));
    }

}
