package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
/*String str = new String("level22.lesson13.task01");
String[] line = getTokens(str,".");
        for (String l:line) {
            System.out.println(l);
        }*/

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tok = new StringTokenizer(query, delimiter);
    //    System.out.println(tok.toString());
        String[] massString = new String[tok.countTokens()];
        int i=0;
        while (tok.hasMoreTokens()){
            massString[i] = tok.nextToken(); i++;
        }
  //      System.out.println(massString.length);
        return massString;
    }
}
