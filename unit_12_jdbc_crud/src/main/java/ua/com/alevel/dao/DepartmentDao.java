package ua.com.alevel.dao;

import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.util.DBOrderUtil;

import java.util.Collection;

public interface DepartmentDao extends BaseDao<Department> {

    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
    Collection<DepartmentDto> findDepartmentStatistics(String sortBy, DBOrderUtil orderBy);
}
