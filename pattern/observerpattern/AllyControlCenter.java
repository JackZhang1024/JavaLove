package observerpattern;

import java.util.ArrayList;

/**
 * 抽象目标类
 * Created by zfz on 2017/12/13.
 */
public abstract class AllyControlCenter {
    protected String allyName;

    protected ArrayList<Observer> players = new ArrayList<>();

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public String getAllyName() {
        return allyName;
    }

    public void join(Observer observer){
        System.out.println(observer.getName()+" 加入 "+allyName+" 战队！");
        players.add(observer);
    }

    public void quit(Observer observer){
        System.out.println(observer.getName()+" 退出 "+allyName+" 战队！");
        players.remove(observer);
    }

    public abstract void notifyObservers(String Name);

}
