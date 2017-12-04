package statepattern.statechange;

/**
 * Created by zfz on 2017/12/17.
 */
public class DieMonsterState extends MonsterState{

    public DieMonsterState(MonsterState monsterState){
        this.monster = monsterState.monster;
    }

    @Override
    public void attack(int amount) {
        System.out.println("怪兽已经死亡，无法进行攻击！");
    }

    @Override
    public void underAttack(int amount) {
        System.out.println("怪兽已经死亡，无法受到攻击！");
    }

    @Override
    public void checkState() {
        System.out.println("怪兽已经死亡！");
    }
}
