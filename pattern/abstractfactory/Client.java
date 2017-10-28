package abstractfactory;

/**
 * 抽象工厂只需要生产某个生产族的产品 例如运动款汽车族 或者 商务款汽车族
 * Created by zfz on 2017/10/27.
 */
public class Client {

    public static void main(String[] args) {
        // 开动运动款汽车
        Drive sportDrive = new SportDrive();
        AudiCar sportAudi = sportDrive.createAudiCar("AudiSport");
        BenzCar sportBenz = sportDrive.createBenzCar("BenzSport");
        sportAudi.drive();
        sportBenz.drive();
        // 开动商务款汽车
        Drive businessDrive = new BusinessDrive();
        AudiCar businessAudi = businessDrive.createAudiCar("AudiBusiness");
        BenzCar businessBenz = businessDrive.createBenzCar("BenzBusiness");
        businessAudi.drive();
        businessBenz.drive();
    }
}
