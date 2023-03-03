package ua.com.alevel;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

    private final Map<Student, String> hashMap = new HashMap<>();
    private final Map<Student, String> linkedHashMap = new LinkedHashMap<>();
    private final Map<Student, String> treeMap = new TreeMap<>();

    public void test() {
//        Student student1 = new Student();
//        student1.setFirstName("test11");
//        student1.setLastName("test12");
//        student1.setAge(34);
//        hashMap.put(student1, "test1");
//
//        student1 = new Student();
//        student1.setFirstName("test21");
//        student1.setLastName("test22");
//        student1.setAge(20);
//        hashMap.put(student1, "test2");
//
//        student1 = new Student();
//        student1.setFirstName("test31");
//        student1.setLastName("test32");
//        student1.setAge(22);
//        hashMap.put(student1, "test3");
//
//        student1 = new Student();
//        student1.setFirstName("test41");
//        student1.setLastName("test42");
//        student1.setAge(21);
//        hashMap.put(student1, "test3");

//        hashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//        });

        System.out.println();

//        student1 = new Student();
//        student1.setFirstName("test11");
//        student1.setLastName("test12");
//        student1.setAge(34);
//        linkedHashMap.put(student1, "test1");
//
//        student1 = new Student();
//        student1.setFirstName("test21");
//        student1.setLastName("test22");
//        student1.setAge(20);
//        linkedHashMap.put(student1, "test2");
//
//        student1 = new Student();
//        student1.setFirstName("test31");
//        student1.setLastName("test32");
//        student1.setAge(22);
//        linkedHashMap.put(student1, "test3");
//
//        student1 = new Student();
//        student1.setFirstName("test41");
//        student1.setLastName("test42");
//        student1.setAge(21);
//        linkedHashMap.put(student1, "test3");

//        linkedHashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//        });

        Student student1 = new Student();
        student1.setFirstName("test11");
        student1.setLastName("test12");
        student1.setAge(34);
        treeMap.put(student1, "test1");

        student1 = new Student();
        student1.setFirstName("test21");
        student1.setLastName("test22");
        student1.setAge(20);
        treeMap.put(student1, "test2");

        student1 = new Student();
        student1.setFirstName("test31");
        student1.setLastName("test32");
        student1.setAge(20);
        treeMap.put(student1, "test3");

        student1 = new Student();
        student1.setFirstName("test41");
        student1.setLastName("test42");
        student1.setAge(21);
        treeMap.put(student1, "test3");

        treeMap.forEach((k, v) -> {
            System.out.println("k = " + k);
        });
    }
}
