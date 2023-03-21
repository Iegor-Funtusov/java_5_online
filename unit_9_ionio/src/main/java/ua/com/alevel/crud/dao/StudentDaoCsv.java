package ua.com.alevel.crud.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.crud.entity.Student;
import ua.com.alevel.crud.util.DbUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoCsv implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        initStudents();
        student.setId(DbUtil.getInstanse().generateId(students));
        students.add(student);
        writeStudentsToCSV();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(String id) {
        initStudents();
        students.removeIf(student -> student.getId().equals(id));
        writeStudentsToCSV();
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        initStudents();
        return students;
    }

    private void initStudents() {
        try(CSVReader csvReader = new CSVReader(new FileReader("students.csv"))) {
            List<String[]> list = csvReader.readAll();
            students = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(list)) {
                for (String[] elements : list) {
                    Student student = new Student();
                    student.setId(elements[0]);
                    student.setFirstName(elements[1]);
                    student.setLastName(elements[2]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeStudentsToCSV() {
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter("students.csv"))) {
            List<String[]> list = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(students)) {
                for (Student student : students) {
                    String[] st = new String[] {
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName()
                    };
                    list.add(st);
                }
                csvWriter.writeAll(list);
                csvWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
