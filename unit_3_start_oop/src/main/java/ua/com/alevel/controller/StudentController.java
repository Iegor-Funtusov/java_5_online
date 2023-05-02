package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// service class
public class StudentController {

    private StudentService studentService;

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
        System.out.println("Please enter the phone:");
        String phone = reader.readLine();
        System.out.println("Please enter the age:");
        String stringAge = reader.readLine();
        int age = Integer.parseInt(stringAge);
        Student student = new Student(123);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPhone(phone);
        student.setAge(age);
        studentService.create(student);
    }

    private void update(BufferedReader reader) throws IOException {}

    private void delete(BufferedReader reader) throws IOException {}

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id:");
        String id = reader.readLine();
        Student student = studentService.findById(id);
        System.out.println("student = " + student);
    }

    private void findAll() {
        Student[] students = studentService.findAll();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }
}
