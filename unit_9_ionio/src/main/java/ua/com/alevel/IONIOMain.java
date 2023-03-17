package ua.com.alevel;

public class IONIOMain {

    public static final String FILE_NAME = "test.txt";
    public static final String DIR_NAME = "test";
    public static final String DIRS_NAME = "test/test1/test2";

    public static void main(String[] args) {
//        new IOTest().test();
//        new NIOTest().test();
        new SerialTest().test();
    }
}
