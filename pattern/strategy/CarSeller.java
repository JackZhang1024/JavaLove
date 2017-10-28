package strategy;

/**
 * Created by zfz on 2017/10/27.
 */
public class CarSeller {

    public AudiCar audiCar;

    public CarSeller(AudiCar audiCar) {
        this.audiCar = audiCar;
    }

    public void order(){
        audiCar.makeCar();
    }
}
