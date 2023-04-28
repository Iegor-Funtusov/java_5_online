package ua.com.alevel.controller;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.annotations.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class MainController {

    @Inject
    private EmployeeController employeeController;
    @Inject
    private DepartmentController departmentController;

    public void start() {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Welcome to the your first crud application");
            System.out.println("Select options:");
            String select;
            menu();
            while ((select = bf.readLine()) != null) {
                crud(bf, select);
            }
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want observ employee, please enter 1");
        System.out.println("If you want observ department, please enter 2");
        System.out.println("If you want close, please enter 3");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> observeEmployees(reader);
            case "2" -> observeDepartments(reader);
            case "3" -> System.exit(0);
        }
        menu();
    }

    private void observeDepartments(BufferedReader reader) throws IOException {
        departmentController.start(reader);
    }

    private void observeEmployees(BufferedReader reader) throws IOException {
        employeeController.start(reader);
    }
}
