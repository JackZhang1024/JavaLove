package visitorpattern;

/**
 * 人力资源部门 具体访问者 计算具体的工作时间
 * Created by zfz on 2017/12/16.
 */
public class HRDepartment implements Department{

    @Override
    public void visit(FullTimeEmployee employee) {
        System.out.println("全职员工 "+employee.getName()+" 工作 "+employee.getWeeks()+" 周");
    }

    @Override
    public void visit(PartTimeEmployee employee) {
        System.out.println("临时员工 "+employee.getName()+" 工作 "+employee.getHours()+" 小时");
    }
}
