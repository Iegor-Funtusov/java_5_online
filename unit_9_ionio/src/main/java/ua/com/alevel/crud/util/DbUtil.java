package ua.com.alevel.crud.util;

import ua.com.alevel.crud.entity.Student;

import java.util.List;
import java.util.UUID;

public final class DbUtil {

    private static DbUtil instanse;

    private DbUtil() { }

    public static DbUtil getInstanse() {
        if (instanse == null) {
            instanse = new DbUtil();
        }
        return instanse;
    }

    public String generateId(List<Student> students) {
        String id = UUID.randomUUID().toString();
        if (students.stream().anyMatch(student -> student.getId().equals(id))) {
            return generateId(students);
        }
        return id;
    }
}
