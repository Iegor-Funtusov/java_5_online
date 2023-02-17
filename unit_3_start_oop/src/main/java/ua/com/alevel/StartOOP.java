package ua.com.alevel;

import ua.com.alevel.controller.StudentController;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.CourseType;
import ua.com.alevel.entity.CourseUtil;
import ua.com.alevel.entity.ImmutableStudent;
import ua.com.alevel.entity.RecordStudent;
import ua.com.alevel.entity.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class StartOOP {

    public static void main(String[] args) throws IOException {

//        Student student1 = new Student();
//        student1.setFirstName("Ivan");
//        student1.setLastName("Ivanov");
//        student1.setAge(31);
//        student1.setInn(123);
//        Student student2 = new Student();
//        student2.setFirstName("Ivan");
//        student2.setLastName("Ivanov");
//        student2.setAge(31);
//        student2.setInn(124);
//        System.out.println("student1 = " + student1);
//        System.out.println("student2 = " + student2);
//
//        long start = System.nanoTime();
//        System.out.println(student1.equals(student2)); // business value
//        long end = System.nanoTime() - start;
//        System.out.println("equals = " + end);
//        System.out.println(student1.hashCode());
//        System.out.println(student2.hashCode());
//        start = System.nanoTime();
//        System.out.println(student1.hashCode() == student2.hashCode());  // system value
//        end = System.nanoTime() - start;
//        System.out.println("hashCode = " + end);

//        System.out.println("CRUD - Create Read Update Delete");
//
//        StudentController studentController = new StudentController();
//        studentController.start();

//        Course course = new Course();
//        course.setCourseName(CourseUtil.JAVA);
//
//        Course course1 = new Course();
//        course1.setCourseName(CourseUtil.JAVA_SCRIPT);
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String courseName = bufferedReader.readLine();
//
//        if (courseName.equals(CourseUtil.JAVA)) {
//            System.out.println("courseName = " + courseName);
//        }
//        if (courseName.equals(CourseUtil.JAVA_SCRIPT)) {
//            System.out.println("courseName = " + courseName);
//        }

//        System.out.println("const = " + CourseUtil.JAVA);
//        System.out.println("enum = " + CourseType.JAVA);
//
//        System.out.println("const = " + CourseUtil.JAVA_SCRIPT);
//        System.out.println("enum = " + CourseType.JAVA_SCRIPT);
//        System.out.println("enum = " + CourseType.JAVA_SCRIPT.getName());

//        final int a = 10;
//        final Student student1 = new Student(124);
//        student1.setInn(120);
//        Student student2 = new Student();
//        student2.setInn(123);
//        student2 = student1;
//        student2.setInn(124);

//        System.out.println("student1 = " + student1.getInn());
//        System.out.println("student2 = " + student2.getInn());


        final ImmutableStudent student = new ImmutableStudent(
                123,
                "fn",
                "ln",
                "phone",
                23,
                100.0,
                true);

        final ImmutableStudent student2 = new ImmutableStudent(
                124,
                "fn",
                "ln",
                "phone",
                23,
                100.0,
                true);

//        student2 = student;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter inn");

        String innString = reader.readLine();
        int inn = Integer.parseInt(innString);

        final ImmutableStudent student3 = new ImmutableStudent(
                inn,
                "fn",
                "ln",
                "phone",
                23,
                100.0,
                true);

        System.out.println("student3 = " + student3);

        Class<?> isClass = student3.getClass();
        Field[] fields = isClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("inn")) {
                field.setAccessible(true);
                try {
                    field.set(student3, 137);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("student3 = " + student3);

        System.out.println("Please enter inn for record");

        innString = reader.readLine();
        inn = Integer.parseInt(innString);

        RecordStudent recordStudent = new RecordStudent(
                inn,
                "fn",
                "ln",
                "phone",
                23,
                100.0,
                true);

        System.out.println("recordStudent = " + recordStudent);

        isClass = recordStudent.getClass();
        fields = isClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("inn")) {
                field.setAccessible(true);
                try {
                    field.set(recordStudent, 137);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
