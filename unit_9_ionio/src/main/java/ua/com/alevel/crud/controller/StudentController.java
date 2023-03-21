package ua.com.alevel.crud.controller;

import ua.com.alevel.crud.dao.StudentDao;
import ua.com.alevel.crud.dao.StudentDaoCsv;
import ua.com.alevel.crud.dao.StudentDaoJson;
import ua.com.alevel.crud.entity.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentController {

    private StudentDao studentDao = new StudentDaoCsv();
//    private StudentDao studentDao = new StudentDaoJson();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the your first crud application");
        System.out.println("Select options:");
        String select;
        menu();
        while ((select = bf.readLine()) != null) {
            crud(bf, select);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("If you want create student, please enter 1");
        System.out.println("If you want update student, please enter 2");
        System.out.println("If you want delete student, please enter 3");
        System.out.println("If you want find student, please enter 4");
        System.out.println("If you want find all students, please enter 5");
        System.out.println("If you want close, please enter 6");
    }

    private void crud(BufferedReader reader, String select) throws IOException {
        switch (select) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "6" -> System.exit(0);
        }
        menu();
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name:");
        String lastName = reader.readLine();
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDao.create(student);
    }

    private void update(BufferedReader reader) throws IOException {}

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id:");
        String id = reader.readLine();
        studentDao.delete(id);
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id:");
        String id = reader.readLine();
        Student student = studentDao.findById(id);
        System.out.println("student = " + student);
    }

    private void findAll() {
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }
}
