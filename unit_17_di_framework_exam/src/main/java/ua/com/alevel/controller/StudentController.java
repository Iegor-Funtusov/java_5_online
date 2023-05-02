package ua.com.alevel.controller;

import ua.com.alevel.annotations.Controller;
import ua.com.alevel.annotations.ControllerMethod;
import ua.com.alevel.annotations.ControllerParam;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.controller.response.DataResponse;
import ua.com.alevel.dto.StudentDto;

@Service
@Controller
public class StudentController {

    @ControllerMethod
    private DataResponse<Boolean> create(@ControllerParam StudentDto dto) {
        System.out.println("dto = " + dto);
        return new DataResponse<>(true);
    }
}
