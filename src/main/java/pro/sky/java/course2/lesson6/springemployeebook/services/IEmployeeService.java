package pro.sky.java.course2.lesson6.springemployeebook.services;

import pro.sky.java.course2.lesson6.springemployeebook.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee add(String firstName, String lastName, double salary, int department);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> getAll();

}
