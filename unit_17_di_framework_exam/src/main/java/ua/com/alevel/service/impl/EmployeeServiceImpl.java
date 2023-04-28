package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private EmployeeDao employeeDao;

    @Override
    public void create(Employee entity) {

    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }
}
