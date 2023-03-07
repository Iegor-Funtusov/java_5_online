package ua.com.alevel;

import java.util.Arrays;
import java.util.List;

public class MapTest {

    public void test() {
        List<String> stringList = Arrays.asList("1", "2", "te", "4", "9", "ihi");

        int sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .mapToInt(value -> value)
                .sum();

        System.out.println("sum = " + sum);

        sum = stringList
                .stream()
                .filter(el -> el.matches("[0-9]"))
                .map(el -> Integer.parseInt(el))
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum = " + sum);
    }
}
