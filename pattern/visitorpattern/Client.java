package visitorpattern;

/**
 * Created by zfz on 2017/12/16.
 */
public class Client {

    public static void main(String[] args) {
        Employee employee0, employee1, employee2, employee3;
        employee0 = new FullTimeEmployee("张三", 20, 3);
        employee1 = new FullTimeEmployee("李四", 20, 4);
        employee2 = new FullTimeEmployee("王五", 20, 6);
        employee3 = new PartTimeEmployee("小强", 10, 30);

        EmployeeList employeeList = new EmployeeList();
        employeeList.addEmployee(employee0);
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);

        Department hrDepartment = new HRDepartment();
        Department fdrDepartment = new FDRDepartment();
        employeeList.accept(hrDepartment);
        employeeList.accept(fdrDepartment);
    }
}
