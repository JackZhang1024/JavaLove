package reflection;

import java.util.List;

/**
 * 因为Java泛型是通过擦除来实现的，很难直接得到泛型具体的参数化类型的信息，
 * 但是我们可以通过一种间接的形式利用反射得到泛型信息。比如下面这个类：
 *
 * Created by zfz on 2018/4/6.
 */
public class GenericObject {

    public List<String> lists;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }
}
