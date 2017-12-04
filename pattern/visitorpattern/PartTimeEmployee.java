package visitorpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public class PartTimeEmployee implements Employee {
    private String name;
    private int hourWage;
    private int hours;

    public PartTimeEmployee(String name, int hourWage, int hours) {
        this.name = name;
        this.hourWage = hourWage;
        this.hours = hours;
    }

    @Override
    public void accept(Department department) {
        department.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getHourWage() {
        return hourWage;
    }

    public int getHours() {
        return hours;
    }
}
