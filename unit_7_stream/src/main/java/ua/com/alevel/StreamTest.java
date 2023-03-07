package ua.com.alevel;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public void test() {
//        int[] ints = [0 ... 10];
        int[] ints = new int[101];
        for (int i = 0; i < 101; i++) {
            ints[i] = i;
        }
        IntStream intStream = IntStream.range(0, 101);
//        intStream.forEach(is -> System.out.println("is = " + is));

        List<Integer> integers1 = Arrays.asList(1, 3, 6, 8,9);
        Stream<Integer> integerStream1 = integers1.stream();

        Stream<Integer> integerStream2 = Stream.of(1, 3, 6, 8,9);

        Stream<Integer> integerStream3 = Arrays.stream(new Integer[]{1, 3, 6, 8,9});

        Stream<Integer> integerStream4 = Stream.<Integer>builder()
                .add(1)
                .add(3)
                .add(6)
                .add(8)
                .add(9)
                .build();

        Stream<Integer> integerStream11 = Stream
                .generate(() -> new Random().nextInt(10, 1000))
                .limit(1_000_000);
        Stream<Integer> integerStream22 = Stream
                .generate(() -> new Random().nextInt(10, 1000))
                .limit(1_000_000);

        long start = System.currentTimeMillis();
        List<Integer> integersFirst = integerStream11
                .filter(integer -> integer % 2 == 0)
                .sorted()
                .distinct()
                .toList();

        long end = System.currentTimeMillis() - start;
//        System.out.println("random end = " + end);

        start = System.currentTimeMillis();
        List<Integer> integersOptimal = integerStream22
                .distinct()
                .filter(integer -> integer % 2 == 0)
                .sorted()
//                .skip(100)
                .limit(10)
                .toList();

        end = System.currentTimeMillis() - start;
//        System.out.println("optimal end = " + end);

        boolean isEven = integersOptimal.stream().allMatch(this::isEven);
        isEven = integersOptimal.stream().noneMatch(this::isEven);
        isEven = integersOptimal.stream().anyMatch(this::isEven);


        System.out.println("isEven = " + isEven);

//        integersOptimal.forEach(integer -> System.out.println("integer = " + integer));


    }

    private boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }
}
