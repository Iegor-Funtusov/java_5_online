package ua.com.alevel;

public class StudentServiceImpl implements StudentService {

    @Override
    public Student create(String fName, String lName, int age) {
        Student student = new Student();
        student.setFirstName(fName);
        student.setLastName(lName);
        student.setAge(age);
        return student;
    }
}
