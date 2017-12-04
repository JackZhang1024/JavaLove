package templatepattern;

/**
 * Created by zfz on 2017/12/17.
 */
public class Client {

    public static void main(String[] args) {
        Work hrSister, boss, programmer;
        hrSister = new HRWorker();
        boss = new BossWorker();
        programmer = new Programmer();

        hrSister.workOneDay();
        boss.workOneDay();
        programmer.workOneDay();
    }
}
