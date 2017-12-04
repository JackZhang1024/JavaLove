package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public class AngleBuilder extends AbstractBuilder{

    @Override
    public void buildGender() {
        actor.setGender("Female");
    }

    @Override
    public void buildFace() {
        actor.setFace("Lovely");
    }

    @Override
    public void buildHairStyle() {
        actor.setHairStyle("Long");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("Cute");
    }


}
