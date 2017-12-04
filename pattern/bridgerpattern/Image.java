package bridgerpattern;

/**
 * 抽象层
 * Created by zfz on 2017/12/12.
 */
public abstract class Image {
    protected ImageImpl imp;

    public void setImp(ImageImpl imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
