package ua.com.alevel;

import ua.com.alevel.controller.StudentController;

import java.io.IOException;

public class StartOOP {

    public static void main(String[] args) throws IOException {
        System.out.println("CRUD - Create Read Update Delete");

        StudentController studentController = new StudentController();
        studentController.start();
    }
}
