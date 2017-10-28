package abstractfactory;

/**
 * Created by zfz on 2017/10/27.
 */
public abstract class AudiCar {

    private String name;

    public AudiCar() {

    }

    public AudiCar(String name){
        this.name = name;
    }

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
