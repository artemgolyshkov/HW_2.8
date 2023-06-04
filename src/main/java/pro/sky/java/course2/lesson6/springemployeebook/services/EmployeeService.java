package pro.sky.java.course2.lesson6.springemployeebook.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.lesson6.springemployeebook.Employee;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.lesson6.springemployeebook.exceptions.FullStorageException;

import java.util.*;

@Service
public class EmployeeService implements IEmployeeService {
    private final Map<String, Employee> employees = new HashMap<>(MAX_SIZE);
    private static final int MAX_SIZE = 5;

    @Override
    public Employee add(String firstName, String lastName, double salary, int department) {
        if (employees.size() >= MAX_SIZE) {
            throw new FullStorageException("Storage is full");
        }
        Employee employeeToAdd = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeAlreadyAddedException("Employee has already added");
        }
        employees.put(createKey(firstName, lastName), employeeToAdd);
        return employeeToAdd;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
        return employees.remove(createKey(firstName, lastName));
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException("Employee doesn't exist");
        }
        return employees.get(createKey(firstName, lastName));
    }

    @Override
    public List<Employee> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(employees.values()));
    }

    private String createKey(String firstName, String lastName) {
        return (firstName + lastName).toLowerCase();
    }
}
