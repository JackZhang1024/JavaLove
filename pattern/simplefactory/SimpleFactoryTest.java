package simplefactory;

/**
 * Created by zfz on 2017/10/24.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
       Product productA = SimpleFactory.createProduct("productA");
       Product productB = SimpleFactory.createProduct("productB");
       productA.displayName();
       productB.displayName();
    }

}
