package ua.com.alevel.facade.impl;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    @Inject
    private DepartmentService departmentService;

    @Override
    public void create(DepartmentDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        departmentService.create(department);
    }

    @Override
    public void update(DepartmentDto dto, Long id) {
        Department department = departmentService.findById(id);
        department.setName(dto.getName());
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        departmentService.delete(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentService.findById(id);
    }

    @Override
    public Collection<Department> findAll() {
        return departmentService.findAll();
    }
}
