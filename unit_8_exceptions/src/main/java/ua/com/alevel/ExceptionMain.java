package ua.com.alevel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionMain {

    public static void main(String[] args) {
        Error error; // unchecked
        StackOverflowError stackOverflowError;
        OutOfMemoryError outOfMemoryError;

        Exception exception; // checked
        SQLException sqlException;
        IOException ioException;
        RuntimeException runtimeException;

//        new ExceptionThreadTest().test();
        new ExceptionCheckTest().test();
    }
}
