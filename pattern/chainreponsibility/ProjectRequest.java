package chainreponsibility;

/**
 * 请求
 * Created by zfz on 2017/12/16.
 */
public class ProjectRequest {

    private int money;
    private String name;

    public ProjectRequest(int money,String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
