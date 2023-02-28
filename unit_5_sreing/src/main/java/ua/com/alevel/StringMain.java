package ua.com.alevel;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringMain {

    public static void main(String[] args) throws InterruptedException {

        String s3 = "fdsfsf fsdfsdf fsdfsdfs fsdfsdf";
        System.out.println("s3 = " + s3);
        String[] s1 = s3.split(" ");
        String newS = "";
        for (String s2 : s1) {
            newS = newS.concat(" ");
            newS = newS.concat(s2);
        }
        System.out.println("newS = " + newS);
//        Student student1 = new Student("Roman", "Romanov");
//        System.out.println("student1 = " + student1);
//        student1.setLastName("Romanov1");
//        Thread.sleep(10000);
//        Student student2 = new Student("Roman", "Romanov");
//        Student student3 = new Student("Roman", "Romanov");
//        Student student4 = new Student("Roman", "Romanov");

//        List<Integer> integers = new ArrayList<>();
//        for (int j = 0; j < 100; j++) {
//            long start = System.currentTimeMillis();
//            for (int i = 0; i < 1_000_000; i++) {
//                integers.add(i);
//            }
//            long end = System.currentTimeMillis() - start;
//            System.out.println("end = " + end);
//        }

//        String s = "Hello world";
//        System.out.println("s length = " + s.length());
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println("aChar = " + aChar);
//        }
//        String pdfFile = "Some.PDF";
//        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) {
////            if (pdfFile.toUpperCase().endsWith(fileType)) {
//            if (pdfFile.toLowerCase().endsWith(fileType.toLowerCase())) {
//                System.out.println("file valid");
//            }
//        }
//
//        for (String fileType: new String[]{ "PDF", "TXT", "DOCX" }) {
//            if (StringUtils.endsWithIgnoreCase(pdfFile, fileType)) {
//                System.out.println("file valid");
//            }
//        }
//
//        String empty = "\n";
//        String blank = " \n";
//        if (!empty.isEmpty()) {
//            System.out.println("not empty");
//        }
//        if (StringUtils.isNotEmpty(empty)) {
//            System.out.println("not empty");
//        }
//        System.out.println("blank = " + blank.isBlank());
//
//        String capitalize = "test test";
//        capitalize = StringUtils.capitalize(capitalize);
//        System.out.println("capitalize = " + capitalize);
//
//        String subs = "Hello world";
//        System.out.println("subs = " + subs);
//        subs = subs.substring(2, 7);
//        System.out.println("subs = " + subs);
//
//        String url = "https://mvnrepository.com/artifact/org.apache.commons/commons-lang3/3.12.0";
//        url = url.replace('2', '8');
//        System.out.println("url = " + url);
//        url = url.replaceAll("https://", "www.");
//        System.out.println("url = " + url);
//
//        int i = url.indexOf('3');
//        System.out.println("i = " + i);
//        i = url.lastIndexOf('/');
//        System.out.println("i = " + i);
//        url = url.substring(0, i);
//        System.out.println("url = " + url);
//
//        String[] strings = url.split("/");
//        for (String string : strings) {
//            System.out.println("string = " + string);
//        }
//
//        String email = " user@gmail.com ";
//        System.out.println("email = " + email);
//        email = email.trim();
//        System.out.println("email = " + email);
//
//        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//        if (email.matches(emailRegex)) {
//            System.out.println("email is valid");
//        } else {
//            System.out.println("email is nat valid");
//        }

        String some = "v2as434fas234";
        String numberRegex = "[0-9]*$";
        System.out.println("some is valid: " + some.matches(numberRegex));

        String number = some.replaceAll("[^0-9]", "");
        System.out.println("number = " + number);
        char[] chars = number.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            String s = String.valueOf(aChar);
            int element = Integer.parseInt(s);
            sum += element;
        }
        System.out.println("sum = " + sum);

        some = "v2as434fas234";
        numberRegex = "[^a-zA-Z]";
        String latins = some.replaceAll(numberRegex, "");
        System.out.println("latins = " + latins);

        char[] charsLatins = latins.toCharArray();

        CharLatin[] charLatins = new CharLatin[charsLatins.length];

        for (int i = 0; i < charsLatins.length; i++) {
            for (int j = 0; j < charLatins.length; j++) {
                if (charLatins[j] == null) {
                    CharLatin charLatin = new CharLatin();
                    charLatin.setLatin(charsLatins[i]);
                    charLatin.setCount(1);
                    charLatins[j] = charLatin;
                    break;
                }
                if (charLatins[j] != null) {
                    if (charLatins[j].getLatin() == charsLatins[i]) {
                        charLatins[j].setCount(charLatins[j].getCount() + 1);
                    }
                }
            }
        }

        for (CharLatin charLatin : charLatins) {
            System.out.println("charLatin = " + charLatin);
        }

//        Pattern pattern = Pattern.compile(numberRegex);

    }
}
