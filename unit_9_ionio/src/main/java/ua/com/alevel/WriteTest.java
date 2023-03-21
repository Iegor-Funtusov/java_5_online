package ua.com.alevel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.stream.Stream;

public class WriteTest {

//    private Reader reader;
//    private Writer writer;
//
//    private InputStream inputStream;
//    private OutputStream outputStream;

    public void test() {
        try {
//            characterRW();
            symbolRW();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        symbolRW();
    }

    private void symbolRW() throws IOException {
//        FileReader fileReader = new FileReader("test.txt");
//        while (fileReader.ready()) {
//            int read = fileReader.read();
//            System.out.println("read = " + read);
//        }

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
//        while (bufferedReader.ready()) {
//            String s = bufferedReader.readLine();
//            System.out.println("s = " + s);
//        }
//        Stream<String> stringStream = bufferedReader.lines();
//        stringStream.forEach(s -> System.out.println("s = " + s));

//        FileWriter fileWriter = new FileWriter("test.txt"); // default behavior
        FileWriter fileWriter = new FileWriter("test.txt", true);
        fileWriter.write("\n");
        fileWriter.write("I'm writing into file");
        fileWriter.flush();
    }

    private void characterRW() throws IOException {
        InputStream inputStream = new FileInputStream("test.txt");
        byte[] bytes = inputStream.readAllBytes();
        for (byte aByte : bytes) {
            System.out.println("aByte = " + (char) aByte);
        }

        OutputStream outputStream = new FileOutputStream("test.txt");
        outputStream.write(new byte[]{104,101,108,108,111,32,119,111,114,108,100});
    }
}
