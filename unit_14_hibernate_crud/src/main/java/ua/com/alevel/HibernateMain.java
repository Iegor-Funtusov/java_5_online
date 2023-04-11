package ua.com.alevel;

import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.EmpoloyeeDao;
import ua.com.alevel.dao.impl.EmpoloyeeDaoImpl;
import ua.com.alevel.entity.Employee;

public class HibernateMain {

    public static void main(String[] args) {
        System.out.println("HibernateMain.main");
        EmpoloyeeDao empoloyeeDao = new EmpoloyeeDaoImpl();

        Employee employee = new Employee();
//        employee.setFirstName("fdsfds");
//        employee.setLastName("dsfsd");
//        employee.setAge(43);
//        employee.setEmail("fdsfsd");
//
//        empoloyeeDao.create(employee);

        employee = empoloyeeDao.findById(1L).get();

        System.out.println("employee = " + employee);

//        employee.setAge(34);

//        empoloyeeDao.update(employee);

        empoloyeeDao.delete(employee);
    }
}
