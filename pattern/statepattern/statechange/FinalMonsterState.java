package statepattern.statechange;

/**
 * Created by zfz on 2017/12/17.
 */
public class FinalMonsterState extends MonsterState {

    public FinalMonsterState(MonsterState monsterState) {
        this.monster = monsterState.monster;
    }

    @Override
    public void attack(int amount) {
        monster.setBlood(monster.getBlood() + amount);
        checkState();
    }

    @Override
    public void underAttack(int amount) {
        monster.setBlood(monster.getBlood() - amount);
        checkState();
    }

    @Override
    public void checkState() {
        if (monster.getBlood() >= 5000) {
            monster.setMonsterState(new FinalMonsterState(this));
        } else if (monster.getBlood() >= 1000 && monster.getBlood() < 5000) {
            monster.setMonsterState(new BigMonsterState(this));
        }
    }
}
