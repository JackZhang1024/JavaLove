package strategy;

/**
 * Created by zfz on 2017/10/27.
 */
public class CarFactory {

    // 服务端生产汽车
    public static AudiCar createCar(String name){
        AudiCar audiCar = null;
        if ("A4".equalsIgnoreCase(name)){
            audiCar = new Audi4Car("A4Audi");
        }else if("A6".equalsIgnoreCase(name)){
            audiCar = new Audi6Car("A6Audi");
        }
        return audiCar;
    }
}
