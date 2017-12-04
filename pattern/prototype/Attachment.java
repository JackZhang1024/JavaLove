package prototype;

import java.io.Serializable;

/**
 * Created by zfz on 2017/12/10.
 */
public class Attachment implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("附件名称 " + name);
    }
}
