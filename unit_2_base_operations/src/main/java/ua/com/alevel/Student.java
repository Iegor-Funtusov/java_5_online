package ua.com.alevel;

public class Student {

    String firstName = "Ivan";
    String lastName = "Ivanov";
    int age;

    String fullName() {
        return firstName + " " + lastName;
    }

    void setAge(int a) {
        age = a;
    }
}
