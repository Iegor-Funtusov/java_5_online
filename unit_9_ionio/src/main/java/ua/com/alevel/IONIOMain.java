package ua.com.alevel;

import ua.com.alevel.crud.controller.StudentController;

import java.io.IOException;

public class IONIOMain {

    public static final String FILE_NAME = "test.txt";
    public static final String DIR_NAME = "test";
    public static final String DIRS_NAME = "test/test1/test2";

    public static void main(String[] args) throws IOException {
//        new IOTest().test();
//        new NIOTest().test();
//        new SerialTest().test();
//        new WriteTest().test();
        StudentController studentController = new StudentController();
        studentController.start();
    }
}
