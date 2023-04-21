package ua.com.alevel.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.persistence.entity.Employee;
import ua.com.alevel.persistence.repositoty.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class CrudTestService {

    private final EmployeeRepository employeeRepository;

    public CrudTestService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void test() {
//        createEmployees();
//        updateEmployees();
//        findAllByAgeBetween();
//        deleteAllByFirstNameContainingIgnoreCase();
//        countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith();
//        existsAllByEmailContainingIgnoreCase();
        datatable();
    }

    private void deleteAllByFirstNameContainingIgnoreCase() {
        employeeRepository.deleteAllByFirstNameContainingIgnoreCase("7");
    }

    private void createEmployees() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setAge(new Random().nextInt(20, 50));
            employee.setEmail("email" + i + "@mail.com");
            employees.add(employee);
        }
        employeeRepository.saveAll(employees);
    }

    private void updateEmployees() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeIterable) {
            employee.setFirstName(employee.getFirstName() + "NewUpdate");
            employee.setLastName(employee.getLastName() + "NewUpdate");
            employees.add(employee);
        }
        employeeRepository.saveAll(employees);
    }

    private void findAllByAgeBetween() {
        List<Employee> employees = employeeRepository.findAllByAgeBetween(30, 40);
        System.out.println("employees = " + employees.size());
    }

    private void countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith() {
        long count = employeeRepository.countAllByFirstNameContainingIgnoreCaseAndAgeBeforeAndLastNameEndsWith("99", 30, "Update");
        System.out.println("count = " + count);
    }

    private void existsAllByEmailContainingIgnoreCase() {
        boolean ex = employeeRepository.existsAllByEmailContainingIgnoreCase("email996@MAIL.com");
        System.out.println("ex = " + ex);
    }

    private void datatable() {
        Page<Employee> page = employeeRepository.findAll(
                PageRequest.of(0, 25, Sort.by("id").descending())
        );
        System.out.println("getTotalPages = " + page.getTotalPages());
        System.out.println("getContent = " + page.getContent());
        System.out.println("getTotalElements = " + page.getTotalElements());
        System.out.println("getSize = " + page.getSize());
        System.out.println("getSort = " + page.getSort());
        System.out.println("getPageable = " + page.getPageable());
    }
}
