package strategy;

/**
 * Created by zfz on 2017/10/27.
 */
public class Audi6Car extends AudiCar {

    public Audi6Car(String name) {
        super(name);
    }

    @Override
    void makeCar() {
        System.out.println(getName() + " created");
    }
}
