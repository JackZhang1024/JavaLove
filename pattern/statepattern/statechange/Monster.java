package statepattern.statechange;

/**
 * Created by zfz on 2017/12/17.
 */
public class Monster {
    private String name; //怪兽的名称
    private int blood;
    private MonsterState monsterState; //怪兽的状态

    public Monster(String name, int blood) {
        this.name = name;
        this.blood = blood;
        monsterState = new LitterMonsterState(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public MonsterState getMonsterState() {
        return monsterState;
    }

    public void setMonsterState(MonsterState monsterState) {
        this.monsterState = monsterState;
    }

    public void attack(int amount) {
        System.out.println("当前怪兽攻击获得血量 " + amount);
        monsterState.attack(amount);
        System.out.println("当前怪兽血量 " + blood);
        System.out.println("当前怪兽状态 " + monsterState.getClass().getName());
        System.out.println("------------------------");
    }

    public void underAttack(int amount) {
        System.out.println("当前怪兽遭到攻击减少血量 " + amount);
        monsterState.underAttack(amount);
        System.out.println("当前怪兽血量 " + blood);
        System.out.println("当前怪兽状态 " + monsterState.getClass().getName());
        System.out.println("------------------------");
    }

}
