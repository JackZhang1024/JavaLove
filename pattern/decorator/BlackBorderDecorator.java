package decorator;

/**
 * Created by zfz on 2017/12/11.
 */
public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    void display() {
        setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("显示黑色边框");
    }
}
