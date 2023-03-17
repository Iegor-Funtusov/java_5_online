package ua.com.alevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

public class SerialTest {

    private final Student student = generateStudent();

    public void test() {
        try {
            serial();
            deserial();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void serial() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.out"));
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
    }

    private void deserial() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.out"));
        Object o = objectInputStream.readObject();
        Student s = (Student) o;
        System.out.println("s = " + s);
    }

    private Student generateStudent() {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setFirstName("fn");
        student.setLastName("ln");
        student.setFullName("fn ln");
        return student;
    }
}
