package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string!=null) {
            String[] lines = string.split("\t");
            String line = string.replaceAll("[^\t]", "");
            if (line.length() < 2) {
                throw new TooShortStringException();
            }

            return lines[1];
        }else { throw new TooShortStringException();}
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }
}
