package ua.com.alevel.dao;

import ua.com.alevel.entity.Employee;

public interface EmpoloyeeDao extends BaseDao<Employee> {

    boolean existsByFirstNameOrLastName(String firstName, String lastName);
}
