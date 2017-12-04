package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public class DevilBuilder extends AbstractBuilder{

    @Override
    public void buildGender() {
        actor.setGender("Male");
    }

    @Override
    public void buildFace() {
        actor.setFace("Ugly");
    }

    @Override
    public void buildHairStyle() {
        actor.setHairStyle("Cursory");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("Short");
    }

    @Override
    public boolean isBareHeaded() {
        return true;
    }
}

