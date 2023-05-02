package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.UUID;

public class StudentServiceImpl implements StudentService {

    private Student[] students = new Student[1];

    public void create(Student student) {
        student.setId(generateId());
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void update(Student student) {}

    public void delete(String id) {}

    public Student findById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Student[] findAll() {
        return students;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
