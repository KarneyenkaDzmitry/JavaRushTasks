package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;
        else {
            int countNumbers = (telNumber.replaceAll("\\D", "")).length();
            //System.out.println(countNumbers);
            String r1 = "[^\\d\\-\\(\\)\\+]";
            String r2 = "^\\+.*";
            String r3 = "^[\\d||\\(].*";
            String r4 = "\\(\\d{3}\\)\\d*\\-?\\d*\\-?\\d*\\d$";
            String r5 = ".*\\-?\\d*\\-?\\d*\\d$";
            String r6 = "[\\(\\)]";

            Pattern patternWords = Pattern.compile(r1);
            Pattern patternPlus = Pattern.compile(r2);
            Pattern patternDB = Pattern.compile(r3);
            Pattern patternLong = Pattern.compile(r4);
            Pattern patternWithout = Pattern.compile(r5);
            Pattern patternBlin = Pattern.compile(r6);

            Matcher matcher = patternWords.matcher(telNumber);
            if (!matcher.find()) {
                Matcher matcher1 = patternPlus.matcher(telNumber);
                if (matcher1.find()) {
                    if (countNumbers == 12) {
                        Matcher matcher2 = patternBlin.matcher(telNumber);


                        if (matcher2.find()) {
                            Matcher matcher3 = patternLong.matcher(telNumber);
                            if (matcher3.find())
                                return true;
                            else return false;
                        } else {
                            Matcher matcher3 = patternWithout.matcher(telNumber);

                            if (matcher3.find())
                                return true;
                            else return false;
                        }
                    } else return false;
                } else {
                    Matcher matcher2 = patternDB.matcher(telNumber);
                    if (matcher2.find()) {
                        if (countNumbers == 10) {
                            Matcher matcher3 = patternBlin.matcher(telNumber);
                            if (matcher3.find()) {
                                Matcher matcher4 = patternLong.matcher(telNumber);
                                if (matcher4.find())
                                    return true;
                                else return false;
                            } else {
                                Matcher matcher4 = patternWithout.matcher((telNumber));
                                if (matcher4.find()) return true;
                                else return false;
                            }
                        } else return false;
                    }
                }
            } else return false;


            return false;
        }
    }

    public static void main(String[] args) {
       /* System.out.println("+380501234567"+" "+checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567"+" "+checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67"+" "+checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567"+" "+checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567"+" "+checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7"+" "+checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567"+" "+checkTelNumber("050ххх4567"));
        System.out.println("050123456"+" "+checkTelNumber("050123456"));
        System.out.println("(0)501234567"+" "+checkTelNumber("(0)501234567"));
        //checkTelNumber("+380501234567");
        //checkTelNumber("+380501234567");*/

    }
}
