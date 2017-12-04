package statepattern.statechange;

/**
 * 抽象状态类
 * Created by zfz on 2017/12/17.
 */
public abstract class MonsterState {
    protected Monster monster;

    // 进攻增加伤害值
    public abstract void attack(int amount);

    // 受进攻减少伤害值
    public abstract void underAttack(int amount);

    // 检查状态
    public abstract void checkState();

}
