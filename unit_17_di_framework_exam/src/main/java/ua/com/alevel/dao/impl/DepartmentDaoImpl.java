package ua.com.alevel.dao.impl;

import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;

import java.util.Collection;
import java.util.Optional;

@Service
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public void create(Department entity) {

    }

    @Override
    public void update(Department entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() {
        return null;
    }

    @Override
    public Collection<Department> findByEmployeeId(Long employeeId) {
        return null;
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {

    }

    @Override
    public void detachEmployeeToDepartment(Long departmentId, Long employeeId) {

    }
}
