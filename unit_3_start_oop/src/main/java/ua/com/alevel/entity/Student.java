package ua.com.alevel.entity;

// data class
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phone;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 6 && age < 50) {
            this.age = age;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                "} " + super.toString();
    }
}
