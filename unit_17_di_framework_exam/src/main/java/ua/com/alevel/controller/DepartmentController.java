package ua.com.alevel.controller;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

@Service
public class DepartmentController {

    @Inject
    private DepartmentService departmentService;

    public void start(BufferedReader bf) throws IOException {
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create department, please enter 1");
        System.out.println("If you want update department, please enter 2");
        System.out.println("If you want delete department, please enter 3");
        System.out.println("If you want find department, please enter 4");
        System.out.println("If you want find all departments, please enter 5");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the name:");
        String name = reader.readLine();
        Department department = new Department();
        department.setName(name);
        departmentService.create(department);
    }

    private void update(BufferedReader reader) throws IOException {}

    private void delete(BufferedReader reader) throws IOException {}

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id:");
        String id = reader.readLine();
        Department department = departmentService.findById(Long.parseLong(id));
        System.out.println("department = " + department);
    }

    private void findAll() {
        Collection<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }
    }
}
