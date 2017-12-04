package decorator;

/**
 * Created by zfz on 2017/12/11.
 */
public class ComponentDecorator extends Component{

    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    void display() {
        component.display();
    }
}
