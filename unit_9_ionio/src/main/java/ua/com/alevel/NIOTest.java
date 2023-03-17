package ua.com.alevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

import static ua.com.alevel.IONIOMain.DIRS_NAME;
import static ua.com.alevel.IONIOMain.DIR_NAME;
import static ua.com.alevel.IONIOMain.FILE_NAME;

public class NIOTest {

//    Path path
//    Paths paths
//    Files files

    public void test() {
        try {
//            createFile(FILE_NAME);
//            createDirectory(DIR_NAME);
//            createDirectories(DIRS_NAME);
//            deleteDirectory(DIR_NAME);
            createTempDirectory(DIR_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFile(String fileName) throws IOException {
//        File file = new File(fileName);
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    private void createDirectory(String dirName) throws IOException {
//        File file = new File(fileName);
        Path path = Paths.get(dirName);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }

    private void createDirectories(String dirName) throws IOException {
//        File file = new File(fileName);
        Path path = Paths.get(dirName);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    private void createTempDirectory(String dirName) throws IOException {
//        File file = new File(fileName);
        Path path = Paths.get("blabla");
        if (!Files.exists(path)) {
            Path alevel = Files.createTempDirectory(path, "alevel1");
            System.out.println("alevel = " + alevel);
        }
    }

    private void deleteDirectory(String dirName) throws IOException {
//        File file = new File(fileName);
        Path path = Paths.get(dirName);
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }
}
