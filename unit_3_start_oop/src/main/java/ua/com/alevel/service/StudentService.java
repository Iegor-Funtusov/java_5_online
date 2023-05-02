package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

import java.util.UUID;

// service class
public interface StudentService {

    void create(Student student);
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    Student[] findAll();
}
