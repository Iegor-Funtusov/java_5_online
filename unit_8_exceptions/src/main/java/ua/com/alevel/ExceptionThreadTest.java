package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class ExceptionThreadTest {

    public void test() {
        System.out.println("start " + Thread.currentThread().getName());
        List<ExceptionThread> exceptionThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExceptionThread exceptionThread = new ExceptionThread("exceptionThread_" + i);
            exceptionThreadList.add(exceptionThread);
        }
        for (ExceptionThread exceptionThread : exceptionThreadList) {
            exceptionThread.start();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}
