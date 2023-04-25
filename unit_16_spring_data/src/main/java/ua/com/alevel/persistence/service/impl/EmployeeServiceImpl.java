package ua.com.alevel.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.persistence.entity.Employee;
import ua.com.alevel.persistence.repositoty.EmployeeRepository;
import ua.com.alevel.persistence.service.EmployeeService;

import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public void create(Employee entity) {
        employeeRepository.save(entity);
        employeeRepository.save(entity);
        employeeRepository.save(entity);
        employeeRepository.save(entity);
        employeeRepository.save(entity);
        employeeRepository.save(entity);
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> findAll(int page, int size, String sortBy, String orderBy) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }
}
