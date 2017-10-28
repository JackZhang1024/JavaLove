package abstractfactory;

/**
 * 抽象工厂
 * Created by zfz on 2017/10/27.
 */
public abstract class Drive {

    abstract AudiCar createAudiCar(String name);

    abstract BenzCar createBenzCar(String name);

}
