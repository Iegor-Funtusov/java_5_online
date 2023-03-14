package ua.com.alevel;

import java.util.Random;

public class ExceptionThread extends Thread {

    public ExceptionThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("thread name = " + name);
        Random random = new Random();
        int val = random.nextInt(2);
        System.out.println("val = " + 10 / val);
    }
}
