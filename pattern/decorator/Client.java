package decorator;

/**
 * Created by zfz on 2017/12/11.
 */
public class Client {

    public static void main(String[] args) {
        Component component, componentSB;
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
        componentSB.display();

        component = new ListBox();
        componentSB = new ScrollBarDecorator(component);
        Component componentBB;
        componentBB = new BlackBorderDecorator(componentSB);
        componentBB.display();

        Component componentTextBox = new TextBox();
        ScrollBarDecorator sbdecorator = new ScrollBarDecorator(componentTextBox);
        Component borderDecorator = new BlackBorderDecorator(sbdecorator);
        borderDecorator.display();
    }
}
