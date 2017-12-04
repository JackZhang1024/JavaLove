package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public abstract class AbstractBuilder {

    protected Actor actor = new Actor();

    public abstract void buildGender();

    public abstract void buildFace();

    public abstract void buildHairStyle();

    public abstract void buildCostume();

    // Hook方法
    public boolean isBareHeaded(){
        return false;
    }

    public Actor create(){
        return actor;
    }

}
