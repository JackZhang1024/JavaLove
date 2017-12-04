package statepattern.statechange;

/**
 * Created by zfz on 2017/12/17.
 */
public class LitterMonsterState extends MonsterState {

    public LitterMonsterState(Monster monster) {
        this.monster = monster;
    }

    public LitterMonsterState(MonsterState monsterState) {
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
        if (monster.getBlood() > 1000) {
            monster.setMonsterState(new BigMonsterState(this));
        } else if (monster.getBlood() > 0 && monster.getBlood() <= 1000) {
            monster.setMonsterState(new LitterMonsterState(this));
        } else {
            monster.setMonsterState(new DieMonsterState(this));
        }
    }
}
