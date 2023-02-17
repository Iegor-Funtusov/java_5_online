package ua.com.alevel.entity;

public record RecordStudent(
        int inn,
        String firstName,
        String lastName,
        String phone,
        int age,
        double sallary,
        boolean active) { }
