package ua.com.alevel.dao;

import ua.com.alevel.entity.Department;

import java.util.Collection;

public interface DepartmentDao extends CrudDao<Department> {

    Collection<Department> findByEmployeeId(Long employeeId);
    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
}
