package reflection;

/**
 * Created by zfz on 2018/4/5.
 */
public class ChildrenObject extends FatherObject {

    private int age = 20;
    private String name = "Rose";
    private int score = 90;
    public String gender = "male";

    public ChildrenObject() {
    }

    public ChildrenObject(int age, String name, int score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    private ChildrenObject(int age, int score){
        this.age = age;
        this.score = score;
        this.name = "Sunny";
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void run() {
        System.out.println(" run ...");
    }


    @Override
    public void doSomeThing() {
        super.doSomeThing();
    }
}
