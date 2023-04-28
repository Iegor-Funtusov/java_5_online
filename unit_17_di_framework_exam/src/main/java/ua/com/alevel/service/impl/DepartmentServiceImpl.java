package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Inject
    private DepartmentDao departmentDao;

    @Override
    public void create(Department entity) {
        departmentDao.create(entity);
    }

    @Override
    public void update(Department entity) {
        departmentDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    @Override
    public Department findById(Long id) {
        Optional<Department> optionalDepartment = departmentDao.findById(id);
        return optionalDepartment.get();
    }

    @Override
    public Collection<Department> findAll() {
        return departmentDao.findAll();
    }
}
