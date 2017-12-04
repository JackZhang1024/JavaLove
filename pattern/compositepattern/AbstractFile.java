package compositepattern;

/**
 * Created by zfz on 2017/12/12.
 */
public abstract class AbstractFile {

    public abstract void add(AbstractFile abstractFile);
    public abstract void remove(AbstractFile abstractFile);
    public abstract AbstractFile get(int i);
    public abstract void killVirus();

}
