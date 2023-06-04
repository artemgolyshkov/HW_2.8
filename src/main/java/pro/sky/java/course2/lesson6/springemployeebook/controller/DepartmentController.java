package pro.sky.java.course2.lesson6.springemployeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> getAllByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.getAllByDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> separateAllByDepartment() {
        return departmentService.separateAllByDepartment();
    }
}
