package ua.com.alevel.crud.dao;

import ua.com.alevel.crud.entity.Student;

import java.util.List;

public interface StudentDao {

    void create(Student student);
    void update(Student student);
    void delete(String id);
    Student findById(String id);
    List<Student> findAll();
}
