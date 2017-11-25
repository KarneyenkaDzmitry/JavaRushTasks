package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        String line = "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ";
        int index,lastIndex;
        System.out.println(index = line.indexOf("\t"));
        System.out.println(lastIndex = line.lastIndexOf("\t"));
        System.out.println(line.substring(index+1,lastIndex));
    }

    public static String getPartOfString(String string) {
        if (string != null){
            String lines[]  = string.split(" ");
            if (lines.length<5){
                throw new TooShortStringException();
            }else {
                return (lines[1]+" "+lines[2]+" "+lines[3]+" "+lines[4]);
            }
        } else throw new IndexOutOfBoundsException();

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
