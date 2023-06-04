package pro.sky.java.course2.lesson6.springemployeebook.services;

import pro.sky.java.course2.lesson6.springemployeebook.Employee;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    Employee getEmployeeWithMaxSalary(int department);

    Employee getEmployeeWithMinSalary(int department);

    List<Employee> getAllByDepartment(int department);

    Map<Integer, List<Employee>> separateAllByDepartment();
}
