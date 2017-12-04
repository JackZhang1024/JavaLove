package decorator;

/**
 * Created by zfz on 2017/12/11.
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    void display() {
        setScrollBar();
        super.display();
    }

    public void addBehaviors(){
        System.out.println("添加一些行为");
    }

    private void setScrollBar() {
        System.out.println("显示滑动条");
    }
}
