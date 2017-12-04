package visitorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zfz on 2017/12/16.
 */
public class EmployeeList {
    private List<Employee> employeeList = new ArrayList<>();

    public void accept(Department department) {
        for (Employee employee : employeeList) {
            employee.accept(department);
        }
    }


    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

}
