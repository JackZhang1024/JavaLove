package strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 策略模式好比顾客直接告诉售卖员我需要那种汽车，然后直接调用生产方法来
 * 生产出来那种汽车
 * 策略模式可以在客户端直接更换策略 比工厂方式更加容易的实现策略
 * 更容易体现在哪了？工厂模式需要更换工厂来生产不同的产品，但是策略模式不需要
 * 只需要更改参数就可以生产不同产品
 * Created by zfz on 2017/10/27.
 */
public class Client {

    public static void main(String[] args) {
        try {
            AudiCar audi4Car = new Audi4Car("Audi4Car");
            CarSeller carSeller1 = new CarSeller(audi4Car);
            carSeller1.order();

            AudiCar audi6Car = new Audi6Car("Audi6Car");
            CarSeller carSeller2 = new CarSeller(audi6Car);
            carSeller2.order();

            System.out.println("请输入你想要的汽车:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String carName = bufferedReader.readLine();
            AudiCar audiCar = CarFactory.createCar(carName);
            audiCar.makeCar();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
