package ua.com.alevel.controller;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

@Service
public class EmployeeController {

    @Inject
    private EmployeeService employeeService;

    public void start(BufferedReader bf) throws IOException {
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create employee, please enter 1");
        System.out.println("If you want update employee, please enter 2");
        System.out.println("If you want delete employee, please enter 3");
        System.out.println("If you want find employee, please enter 4");
        System.out.println("If you want find all employees, please enter 5");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        System.out.println("Please enter the age:");
        String stringAge = reader.readLine();
        int age = Integer.parseInt(stringAge);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employeeService.create(employee);
    }

    private void update(BufferedReader reader) throws IOException {}

    private void delete(BufferedReader reader) throws IOException {}

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id:");
        String id = reader.readLine();
        Employee employee = employeeService.findById(Long.parseLong(id));
        System.out.println("employee = " + employee);
    }

    private void findAll() {
        Collection<Employee> employees = employeeService.findAll();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }
}
