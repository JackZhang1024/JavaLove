package abstractfactory;

/**
 * Created by zfz on 2017/10/27.
 */
public class BusinessDrive extends Drive{

    @Override
    BenzCar createBenzCar(String name) {
        return new BenzBusinessCar(name);
    }

    @Override
    AudiCar createAudiCar(String name) {
        return new AudiBusinessCar(name);
    }
}
