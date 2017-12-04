package statepattern.contextchange;

/**
 * 正常状态
 * Created by zfz on 2017/12/17.
 */
public class NormalState implements State{

    @Override
    public void display() {
        System.out.println("正常放大");
    }
}
