package abstractfactory;

/**
 * 具体工厂实现运动款汽车制造
 * Created by zfz on 2017/10/27.
 */
public class SportDrive extends Drive{

    @Override
    AudiCar createAudiCar(String name) {
        return new AudiSportCar(name);
    }

    @Override
    BenzCar createBenzCar(String name) {
        return new BenzSportCar(name);
    }
}
