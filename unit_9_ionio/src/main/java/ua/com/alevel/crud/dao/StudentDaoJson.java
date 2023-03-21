package ua.com.alevel.crud.dao;

import com.google.gson.Gson;
import ua.com.alevel.crud.entity.Student;
import ua.com.alevel.crud.util.DbUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoJson implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        readStudentsFromJson();
        student.setId(DbUtil.getInstanse().generateId(students));
        students.add(student);
        writeStudentsToJson();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        readStudentsFromJson();
        return students;
    }

    private void readStudentsFromJson() {
        Gson gson = new Gson();
        try {
            Student[] fromJson = gson.fromJson(new FileReader("students.json"), Student[].class);
            if (fromJson != null) {
                students = new ArrayList<>();
                students.addAll(Arrays.asList(fromJson));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeStudentsToJson() {
        Gson gson = new Gson();
        List<Student> list = students.stream()
                .peek(student -> student.setFullName(student.getFirstName() + " " + student.getLastName()))
                .toList();
        String toJson = gson.toJson(list);
        try(FileWriter writer = new FileWriter("students.json")) {
            writer.write(toJson);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
