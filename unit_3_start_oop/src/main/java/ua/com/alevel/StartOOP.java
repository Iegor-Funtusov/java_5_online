package ua.com.alevel;

import ua.com.alevel.controller.StudentController;
import ua.com.alevel.entity.Student;

import java.io.IOException;

public class StartOOP {

    public static void main(String[] args) throws IOException {

        Student student1 = new Student();
        student1.setFirstName("Ivan");
        student1.setLastName("Ivanov");
        student1.setAge(31);
        student1.setInn(123);
        Student student2 = new Student();
        student2.setFirstName("Ivan");
        student2.setLastName("Ivanov");
        student2.setAge(31);
        student2.setInn(124);
        System.out.println("student1 = " + student1);
        System.out.println("student2 = " + student2);

        long start = System.nanoTime();
        System.out.println(student1.equals(student2)); // business value
        long end = System.nanoTime() - start;
        System.out.println("equals = " + end);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        start = System.nanoTime();
        System.out.println(student1.hashCode() == student2.hashCode());  // system value
        end = System.nanoTime() - start;
        System.out.println("hashCode = " + end);

//        System.out.println("CRUD - Create Read Update Delete");
//
//        StudentController studentController = new StudentController();
//        studentController.start();
    }
}
