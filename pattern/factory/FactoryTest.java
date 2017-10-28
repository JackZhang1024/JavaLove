package factory;

/**
 * Created by zfz on 2017/10/24.
 */
public class FactoryTest {

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();
        Product productA = factoryA.makeProduct();
        Product productB = factoryB.makeProduct();
        productA.displayName();
        productB.displayName();
    }
}
