package pro.sky.java.course2.lesson6.springemployeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee add(String firstName, String lastName, double salary, int department) {
        return employeeService.add(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee remove(String firstName, String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(String firstName, String lastName) {
        return employeeService.find(firstName, lastName);
    }
}
