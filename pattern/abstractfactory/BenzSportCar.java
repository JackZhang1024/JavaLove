package abstractfactory;

/**
 * Created by zfz on 2017/10/27.
 */
public class BenzSportCar extends BenzCar{

    public BenzSportCar(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(getName()+" driving.....");
    }
}
