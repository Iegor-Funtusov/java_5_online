package ua.com.alevel.facade.impl;

import ua.com.alevel.annotations.Service;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.Collection;

@Service
@Deprecated
public class EmployeeFacadeImpl2 implements EmployeeFacade {

    public EmployeeFacadeImpl2() {
        System.out.println("EmployeeFacadeImpl2.EmployeeFacadeImpl2");
    }

    @Override
    public void create(EmployeeDto dto) {

    }

    @Override
    public void update(EmployeeDto dto, Long id) {

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
