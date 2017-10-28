package factory;

/**
 * Created by zfz on 2017/10/24.
 */
public class FactoryB implements Factory {

    @Override
    public Product makeProduct() {
        return new ProductB();
    }
}
