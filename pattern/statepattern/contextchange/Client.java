package statepattern.contextchange;

/**
 * Created by zfz on 2017/12/17.
 */
public class Client {

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.doClick(); // large
        screen.doClick(); // largest
        screen.doClick(); // normal
    }
}
