package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionCheckTest {

    public void test() {
//        task1(0);
//        task2(0);
        task3(0);
    }

    private void task1(int a) {
        if (a == 0) {
            throw new RuntimeException("invalid value: is zero");
        }
        System.out.println("a = " + 10 / a);
    }

    private void task2(int a) throws Exception {
        System.out.println("a = " + 10 / a);
    }

    private void task3(int a) {
        try {
//            System.exit(0);
            System.out.println("a = " + 10 / a);
        } catch (ArithmeticException e) {
            System.out.println("invalid value: is zero");
        } catch (RuntimeException e) {
            System.out.println("e = " + e.getMessage());
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        } finally {
            System.out.println("finally block");
        }
        System.out.println("task3 finish");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            Integer i = Integer.parseInt(s);
            int a1 = 10 / i;
            System.out.println("s = " + s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
