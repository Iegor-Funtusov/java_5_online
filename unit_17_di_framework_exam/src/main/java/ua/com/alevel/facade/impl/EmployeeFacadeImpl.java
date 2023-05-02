package ua.com.alevel.facade.impl;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
//@Deprecated
public class EmployeeFacadeImpl implements EmployeeFacade {

    public EmployeeFacadeImpl() {
        System.out.println("EmployeeFacadeImpl.EmployeeFacadeImpl");
    }

    @Inject
    private EmployeeService employeeService;

    @Override
    public void create(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employeeService.create(employee);
    }

    @Override
    public void update(EmployeeDto dto, Long id) {
       Employee employee = employeeService.findById(id);
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setAge(dto.getAge());
        employeeService.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeService.findById(id);
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
