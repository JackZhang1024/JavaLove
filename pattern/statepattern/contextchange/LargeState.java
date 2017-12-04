package statepattern.contextchange;

/**
 * Created by zfz on 2017/12/17.
 */
public class LargeState implements State{

    @Override
    public void display() {
        System.out.println("2倍放大");
    }
}
