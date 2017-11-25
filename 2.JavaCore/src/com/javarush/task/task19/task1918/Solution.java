package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();//D:\Java\Work\Task1918\TagFile.txt
        reader.close();
        String lineString = new String();
        BufferedReader readerFile = new BufferedReader(new FileReader(nameFile));
        while (readerFile.ready()) {
            lineString = lineString + readerFile.readLine();
        }
        readerFile.close();
        System.out.println(lineString);
        System.out.println(args[0]);

        while (lineString.length() > 0) {
            String tagFinish = "</" + args[0] ;
            Pattern pattern1 = Pattern.compile("<" + args[0] );
            Pattern pattern2 = Pattern.compile(tagFinish);
            Matcher matcher1 = pattern1.matcher(lineString);
            Matcher matcher2 = pattern2.matcher(lineString);
            matcher1.find();
            matcher2.find();
            //System.out.println(matcher1.start() + " " + matcher2.end());
            int start = matcher1.start();
            int index = Method(matcher2.end(), matcher2.end(), lineString, args[0],matcher2.end()+1);

            String line = lineString.substring(start,index);
            lineString = lineString.replace(line,"");
            System.out.println(line);
        }
    }

        public  static int Method (int indIn, int indOut ,String str, String tag,int indEnd){
            String tagFinish = "</" + tag ;
            Pattern pattern1 = Pattern.compile("<"+tag);
            Pattern pattern2 = Pattern.compile(tagFinish);
            String str1 = str.substring(indIn,str.length());
            //System.out.println(str1);
            String str2 = str.substring(indOut,str.length());
            //System.out.println(str2);
            Matcher matcher1 = pattern1.matcher(str1);
            Matcher matcher2 = pattern2.matcher(str2);
            int index = indEnd;
            while (true) {
                matcher1.find();
                matcher2.find();
                if (matcher1.end() < indOut) {

                    index =matcher2.end() + 1;

                }else {break;}
            }
                return index;
        }
}
