package factory;

/**
 * Created by zfz on 2017/10/24.
 */
public class FactoryA implements Factory{

    @Override
    public Product makeProduct() {
        return new ProductA();
    }
}
