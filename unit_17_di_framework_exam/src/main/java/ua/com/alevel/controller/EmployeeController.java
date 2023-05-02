package ua.com.alevel.controller;

import ua.com.alevel.annotations.Controller;
import ua.com.alevel.annotations.ControllerMethod;
import ua.com.alevel.annotations.ControllerParam;
import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.controller.response.DataResponse;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

@Service
@Controller
public class EmployeeController {

    @Inject
    private EmployeeFacade employeeFacade;

    @ControllerMethod
    private DataResponse<Boolean> create(@ControllerParam EmployeeDto dto) {
        System.out.println("dto = " + dto);
        employeeFacade.create(dto);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 2)
    private DataResponse<Boolean> update(@ControllerParam Long id, EmployeeDto dto) {
        employeeFacade.update(dto, id);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 3)
    private DataResponse<Boolean> delete(@ControllerParam Long id) {
        employeeFacade.delete(id);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 4)
    private DataResponse<Employee> findById(@ControllerParam Long id) {
        return new DataResponse<>(employeeFacade.findById(id));
    }

    @ControllerMethod(position = 5)
    private DataResponse<Collection<Employee>> findAll() {
        return new DataResponse<>(employeeFacade.findAll());
    }
}
