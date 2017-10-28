package abstractfactory;

/**
 * Created by zfz on 2017/10/27.
 */
public class AudiSportCar extends AudiCar{

    public AudiSportCar(String name) {
        super(name);
    }

    @Override
    public void drive() {
        System.out.println(getName()+" driving............");
    }
}
