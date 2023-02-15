package ua.com.alevel.entity;

import java.util.Objects;

// data class
public class Student extends BaseEntity {

    private int inn;
    private String firstName;
    private String lastName;
    private String phone;
    private int age;
    private double sallary;
    private boolean active;

    public Student() {
        this.age = 0;
        this.sallary = 0.0;
        this.active = true;
    }

    public void Student() { }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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
                "id='" + getId() + '\'' +
                ", inn='" + inn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age + '\'' +
                ", sallary=" + sallary + '\'' +
                ", active=" + active +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

//        if (age != student.age) return false;
//        if (Double.compare(student.sallary, sallary) != 0) return false;
//        if (active != student.active) return false;
//        if (!Objects.equals(firstName, student.firstName)) return false;
//        if (!Objects.equals(lastName, student.lastName)) return false;
//        return Objects.equals(phone, student.phone);
        return Objects.equals(inn, student.inn);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(sallary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
