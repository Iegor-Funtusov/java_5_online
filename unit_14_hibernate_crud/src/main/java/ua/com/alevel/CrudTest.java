package ua.com.alevel;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.dao.impl.EmpoloyeeDaoImpl;
import ua.com.alevel.datatable.DataTableRequest;
import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.Random;

public class CrudTest {

    private final EmpoloyeeDao employeeDao = new EmpoloyeeDaoImpl();
    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    private Employee employee = new Employee();

    public void run() {
//        createEmployee();
//        createDepartment();
//        attachEmployeeToDepartment();
//        detachEmployeeFromDepartment();
//        createEmployeeList();
        dataTable();
    }

    public void createEmployee() {
        employee.setFirstName("fs");
        employee.setLastName("gasgasgas");
        employee.setAge(22);
        employee.setEmail("fdsafasfdsfas");

        employeeDao.create(employee);
    }

    public void createEmployeeList() {
        for (int i = 0; i < 1000; i++) {
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setAge(new Random().nextInt(20, 35));
            employee.setEmail("email" + i + "@gmail.com");
            employeeDao.create(employee);
        }
    }

    public void updateEmployee() {
        employee.setFirstName("fdsfds");
        employee.setLastName("dsfsd");
        employee.setAge(43);
        employee.setEmail("fdsfsd");

        employeeDao.create(employee);
    }

    public void deleteEmployee() {
        employeeDao.delete(employee);
    }

    public void createDepartment() {
        Department department = new Department();
        department.setName("JAVA");
        departmentDao.create(department);
    }

    public void attachEmployeeToDepartment() {
        Department department = departmentDao.findById(2L).get();
        Employee employee2 = employeeDao.findById(2L).get();
        Employee employee3 = employeeDao.findById(3L).get();
        departmentDao.attachEmployeeToDepartment(department, employee2);
        departmentDao.attachEmployeeToDepartment(department, employee3);
    }

    public void detachEmployeeFromDepartment() {
        Department department = departmentDao.findById(2L).get();
        Employee employee2 = employeeDao.findById(2L).get();
        departmentDao.detachEmployeeToDepartment(department, employee2);
    }

    public void dataTable() {
        DataTableRequest dataTableRequest = new DataTableRequest();
        dataTableRequest.setPage(3);
        dataTableRequest.setSize(10);
        dataTableRequest.setOrderBy("asc");
        dataTableRequest.setSortBy("email");
        DataTableResponse<Employee> response = employeeDao.findAll(dataTableRequest);
        for (Employee item : response.getItems()) {
            System.out.println("item = " + item);
        }
    }
}
