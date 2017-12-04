package observerpattern;

/**
 * 抽象观察者
 * Created by zfz on 2017/12/13.
 */
public interface Observer {

    public String getName();

    public void setName(String name);

    public void help(); // 声明支援盟友方法

    public void beAttacked(AllyControlCenter acc); // 声明遭到攻击方法

}
