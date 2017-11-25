package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);
        String outputLines = byteArrayOutputStream.toString();
        //System.out.println(outputLines);
        String line = "eleven\ntwelve\nthirteen\nforteen\nfifteen\n";
        //System.out.println(line);
        Pattern pattern = Pattern.compile("^?\\S+\\s");
        Matcher matcher = pattern.matcher(outputLines);
        int count = 0;
        while (matcher.find()) {
            System.out.println(outputLines.substring(matcher.start(), matcher.end()));
            count++;
            if (count % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");

        }
    }
}
