package visitorpattern;

/**
 * 全职员工具体元素
 * Created by zfz on 2017/12/16.
 */
public class FullTimeEmployee implements Employee{

    private String name;
    private int weeklyWage;
    private int weeks;

    public FullTimeEmployee(String name, int weeklyWage, int weeks) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.weeks = weeks;
    }

    @Override
    public void accept(Department department) {
       department.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getWeeklyWage() {
        return weeklyWage;
    }

    public int getWeeks() {
        return weeks;
    }
}
