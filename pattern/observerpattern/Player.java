package observerpattern;

/**
 * Created by zfz on 2017/12/13.
 */
public class Player implements Observer{

    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住 "+name+" 来救你");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        acc.notifyObservers(name);
    }
}
