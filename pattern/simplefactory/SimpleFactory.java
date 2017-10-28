package simplefactory;

/**
 * Created by zfz on 2017/10/24.
 */
public class SimpleFactory {

    public static Product createProduct(String arg){
        Product product =null;
        if (arg!=null && arg.equals("productA")){
            product = new ProductA();
        }else if(arg!=null && arg.equals("productB")){
            product = new ProductB();
        }
        return product;
    }
}
