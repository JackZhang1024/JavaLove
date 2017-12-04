package builder;

/**
 * Created by zfz on 2017/12/10.
 */
public class Client {

    public static void main(String[] args) {
        AbstractBuilder abstractBuilder = (AbstractBuilder) XmlUtils.getBean();
        Director director = new Director();
        Actor actor = director.construct(abstractBuilder);
        System.out.println("性别 "+actor.getGender());
        System.out.println("面貌 "+actor.getFace());
        System.out.println("发型 "+actor.getHairStyle());
        System.out.println("服饰 "+actor.getCostume());

    }
}
