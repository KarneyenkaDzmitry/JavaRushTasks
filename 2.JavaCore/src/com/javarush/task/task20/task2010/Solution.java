package com.javarush.task.task20.task2010;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int countStrings;

//    public static void load (InputStream inputStream) throws Exception{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        countStrings = Integer.parseInt(reader.readLine());
//        reader.close();
//    }
//    public static void save (OutputStream outputStream){
//        PrintWriter
    //}

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
