package ua.com.alevel;

import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.dao.impl.EmpoloyeeDaoImpl;
import ua.com.alevel.entity.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JdbcCrudMain {

    public static void main(String[] args) {
        EmpoloyeeDao empoloyeeDao = new EmpoloyeeDaoImpl();
        Employee employee = new Employee();
        employee.setFirstName("FL");
        employee.setLastName("LN");
        employee.setAge(45);
//        empoloyeeDao.create(employee);

        employee.setAge(56);
        employee.setId(12L);
//        empoloyeeDao.update(employee);

        empoloyeeDao.delete(12L);

        Collection<Employee> empoloyees = empoloyeeDao.findAll();
        Employee employee1 = empoloyeeDao.findById(3L);

        empoloyeeDao.existsByFirstNameOrLastName("Павло", "Пос");

//        List<Integer> integers = Arrays.asList(1);
//
//        Integer integer = integers.get(0);
//
//        Iterator<Integer> iterator = integers.iterator();
//        iterator.next();

    }
}
