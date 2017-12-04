package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public class HeroBuilder extends AbstractBuilder{

    @Override
    public void buildGender() {
        actor.setGender("Male");
    }

    @Override
    public void buildFace() {
        actor.setFace("HandSome");
    }

    @Override
    public void buildHairStyle() {
        actor.setHairStyle("Short");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("Hero");
    }
}
