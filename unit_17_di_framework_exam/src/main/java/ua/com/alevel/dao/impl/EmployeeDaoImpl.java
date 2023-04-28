package ua.com.alevel.dao.impl;

import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

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
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }

    @Override
    public Collection<Employee> findByDepartmentId(Long departmentId) {
        return null;
    }
}
