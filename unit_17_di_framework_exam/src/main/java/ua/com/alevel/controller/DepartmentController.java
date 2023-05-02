package ua.com.alevel.controller;

import ua.com.alevel.annotations.Controller;
import ua.com.alevel.annotations.ControllerMethod;
import ua.com.alevel.annotations.ControllerParam;
import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.controller.response.DataResponse;
import ua.com.alevel.dto.DepartmentDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;

import java.io.IOException;
import java.util.Collection;

@Service
@Controller
public class DepartmentController {

    @Inject
    private DepartmentFacade departmentFacade;

    @ControllerMethod
    private DataResponse<Boolean> create(@ControllerParam DepartmentDto dto) throws IOException {
        departmentFacade.create(dto);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 2)
    private DataResponse<Boolean> update(@ControllerParam Long id, @ControllerParam DepartmentDto dto) {
        departmentFacade.update(dto, id);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 3)
    private DataResponse<Boolean> delete(@ControllerParam Long id) {
        departmentFacade.delete(id);
        return new DataResponse<>(true);
    }

    @ControllerMethod(position = 4)
    private DataResponse<Department> findById(@ControllerParam Long id) {
        return new DataResponse<>(departmentFacade.findById(id));
    }

    @ControllerMethod(position = 5)
    private DataResponse<Collection<Department>> findAll() {
        return new DataResponse<>(departmentFacade.findAll());
    }
}
