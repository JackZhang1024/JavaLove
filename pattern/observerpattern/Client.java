package observerpattern;

/**
 * Created by zfz on 2017/12/13.
 */
public class Client {

    public static void main(String[] args) {
        AllyControlCenter acc;
        acc = new ConcreteAllyControlCenter("勇者无敌");

        Observer observer1, observer2, observer3;
        observer1 = new Player("Jack");
        observer2 = new Player("Nick");
        observer3 = new Player("Rose");

        acc.join(observer1);
        acc.join(observer2);
        acc.join(observer3);

        observer1.beAttacked(acc);

    }

}
