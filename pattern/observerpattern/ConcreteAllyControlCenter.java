package observerpattern;

/**
 * Created by zfz on 2017/12/13.
 */
public class ConcreteAllyControlCenter extends AllyControlCenter {

    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组建成功");
        this.allyName = allyName;
    }

    @Override
    public void notifyObservers(String name) {
        System.out.println(this.allyName + " 战队紧急通知,盟友 " + name + "受到攻击！");
        for (Observer observer : players) {
            if (!observer.getName().equalsIgnoreCase(name)) {
                observer.help();
            }
        }

    }
}
