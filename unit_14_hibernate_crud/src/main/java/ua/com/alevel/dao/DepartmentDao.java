package ua.com.alevel.dao;

import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.util.DBOrderUtil;

import java.util.Collection;

public interface DepartmentDao extends BaseDao<Department> {

    void attachEmployeeToDepartment(Department department, Employee employee);
    void detachEmployeeToDepartment(Department department, Employee employee);
    Collection<DepartmentDto> findDepartmentStatistics(String sortBy, DBOrderUtil orderBy);
}
