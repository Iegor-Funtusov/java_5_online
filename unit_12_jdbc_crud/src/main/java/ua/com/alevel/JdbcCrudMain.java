package ua.com.alevel;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.dao.impl.DepartmentDaoImpl;
import ua.com.alevel.dao.impl.EmpoloyeeDaoImpl;
import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.util.DBOrderUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class JdbcCrudMain {

    public static void main(String[] args) {
        EmpoloyeeDao empoloyeeDao = new EmpoloyeeDaoImpl();
        DepartmentDao departmentDao = new DepartmentDaoImpl();

//        Department department = new Department();
//        department.setName("DEV_OPS");
//        departmentDao.create(department);

//        Optional<Employee> optionalEmployee = empoloyeeDao.findById(6L);
//        if (optionalEmployee.isPresent()) {
//            Employee employee = optionalEmployee.get();
//            departmentDao.attachEmployeeToDepartment(4L, employee.getId());
//        }

        Collection<DepartmentDto> dtos = departmentDao.findDepartmentStatistics("employee_count", DBOrderUtil.ASC);
        dtos.forEach(System.out::println);
    }
}
