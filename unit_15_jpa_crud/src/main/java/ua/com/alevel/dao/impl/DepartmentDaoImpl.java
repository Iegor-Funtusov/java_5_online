package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.datatable.DataTableRequest;
import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.Department;

import java.util.Optional;

@Service
public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public void create(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Department department) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public DataTableResponse<Department> findAll(DataTableRequest request) {
        return null;
    }
}
