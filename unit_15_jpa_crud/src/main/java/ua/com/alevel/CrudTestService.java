package ua.com.alevel;

import org.springframework.stereotype.Service;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

@Service
public class CrudTestService {

    private final DepartmentDao departmentDao;
    private final EmployeeDao employeeDao;

    public CrudTestService(DepartmentDao departmentDao, EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeDao = employeeDao;
    }

    public void test() {
        createEmployee();
    }

    public void createEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("fs");
        employee.setLastName("gasgasgas");
        employee.setAge(22);
        employee.setEmail("fdsafasfdsfas");
        employeeDao.create(employee);
    }
}
