package statepattern.statechange;

/**
 * Created by zfz on 2017/12/17.
 */
public class Client {

    public static void main(String[] args) {
        Monster monster = new Monster("小强", 100); // 怪兽小强初始血量100
        monster.attack(200);
        monster.attack(200);
        monster.attack(200);
        monster.attack(200);
        monster.attack(200);
        monster.attack(200);
        monster.attack(200);
        monster.attack(2000);
        monster.attack(2000);
        monster.underAttack(500);
        monster.underAttack(100);
        monster.underAttack(3000);
        monster.underAttack(400);

    }

}
