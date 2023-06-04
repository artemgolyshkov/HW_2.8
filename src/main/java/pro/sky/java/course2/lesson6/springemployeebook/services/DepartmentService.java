package pro.sky.java.course2.lesson6.springemployeebook.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getAllByDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> separateAllByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
