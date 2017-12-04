package commandpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2017/12/16.
 */
public class SBPanelSettings {

    private List<SButton> invokers = new ArrayList<>();

    public void addSBInvoker(SButton invoker) {
        invokers.add(invoker);
    }

    public void removeInvoker(SButton invoker) {
        invokers.remove(invoker);
    }

    public void display() {
        for (SButton invoker : invokers) {
            System.out.println(invoker.getName());
        }
    }

}
