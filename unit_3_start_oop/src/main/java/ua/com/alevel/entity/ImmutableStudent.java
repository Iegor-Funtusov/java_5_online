package ua.com.alevel.entity;

import java.util.Objects;

// immutable data class
public class ImmutableStudent {

    private final int inn;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final int age;
    private final double sallary;
    private final boolean active;

    public ImmutableStudent(
            int inn,
            String firstName,
            String lastName,
            String phone,
            int age,
            double sallary,
            boolean active) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.sallary = sallary;
        this.active = active;
    }

    public int getInn() {
        return inn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public double getSallary() {
        return sallary;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
                "inn=" + inn +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sallary=" + sallary +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableStudent student)) return false;

        if (inn != student.inn) return false;
        if (age != student.age) return false;
        if (Double.compare(student.sallary, sallary) != 0) return false;
        if (active != student.active) return false;
        if (!Objects.equals(firstName, student.firstName)) return false;
        if (!Objects.equals(lastName, student.lastName)) return false;
        return Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = inn;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(sallary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
