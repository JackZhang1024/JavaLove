package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public class Director {

    public Actor construct(AbstractBuilder builder) {
        builder.buildGender();
        builder.buildFace();
        if (!builder.isBareHeaded()) {
            builder.buildHairStyle();
        }
        builder.buildCostume();
        return builder.create();
    }

}
