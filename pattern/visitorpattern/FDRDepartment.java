package visitorpattern;

/**
 * 财务部门 具体访问者 计算员工薪水
 * Created by zfz on 2017/12/16.
 */
public class FDRDepartment implements Department {

    @Override
    public void visit(FullTimeEmployee employee) {
        int salary = employee.getWeeks()*employee.getWeeklyWage();
        if (employee.getWeeks() < 4) {
            salary = salary - 100;
            System.out.println("正式员工 "+employee.getName()+ "出勤不满四周，工资扣除交通费用 共计"+salary);
        }else if (employee.getWeeks() == 4){
            salary = salary + 100;
            System.out.println("正式员工 "+employee.getName()+ "出勤满四周，工资加交通费用 共计"+salary);
        }else{
            salary = salary +100 + (employee.getWeeks()-4)*200;
            System.out.println("正式员工 "+employee.getName()+ "出勤超过四周，工资加交通费用 加班费 共计"+salary);
        }
    }

    @Override
    public void visit(PartTimeEmployee employee) {
        int salary = employee.getHours()*employee.getHourWage();
        System.out.println("临时员工 "+employee.getName()+ " 薪水共计共计"+salary);
    }
}
