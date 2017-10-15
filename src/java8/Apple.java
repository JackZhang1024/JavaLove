package java8;
/**
 * Created by zfz on 2017/2/26.
 */
public class Apple {
    private String color;
    private int heavyWeight;

    public Apple() {
    }

    public Apple(String color, int heavyWeight) {
        this.color = color;
        this.heavyWeight = heavyWeight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeavyWeight() {
        return heavyWeight;
    }

    public void setHeavyWeight(int heavyWeight) {
        this.heavyWeight = heavyWeight;
    }
}
