package ua.com.alevel;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static ua.com.alevel.IONIOMain.DIRS_NAME;
import static ua.com.alevel.IONIOMain.DIR_NAME;
import static ua.com.alevel.IONIOMain.FILE_NAME;

public class IOTest {

    public void test() {
        try {
//            createFile(FILE_NAME);
//            deleteFile(FILE_NAME);
//            createDir(DIR_NAME);
//            createDirs(DIRS_NAME);
//            deleteDirs(DIRS_NAME);
//            read(DIR_NAME);
            deleteByCommonsLib(DIR_NAME);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        boolean isFile = file.isFile();
        System.out.println("isFile = " + isFile);
        file.createNewFile();
        isFile = file.isFile();
        System.out.println("isFile = " + isFile);
    }

    private void deleteFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.delete();
    }

    private void createDir(String dirName) throws IOException {
        File file = new File(dirName);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);
        file.mkdir();
        isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);
    }

    private void createDirs(String dirsName) throws IOException {
        File file = new File(dirsName);
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        boolean isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);
        file.mkdirs();
        isDirectory = file.isDirectory();
        System.out.println("isDirectory = " + isDirectory);
    }

    private void deleteDirs(String dirsName) throws IOException {
        File file = new File(dirsName + "/test2.txt");
        file.delete();
    }

    private void read(String fileName) throws IOException {
        File file = new File(fileName);
        readDir(file);
    }

    private void readDir(File dir) {
        System.out.println("dir = " + dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                readDir(file);
            } else {
                System.out.println("file = " + file);
            }
        }
    }

    private void deleteByCommonsLib(String dir) throws IOException {
        File file = new File(dir);
        FileUtils.deleteDirectory(file);
    }
}
