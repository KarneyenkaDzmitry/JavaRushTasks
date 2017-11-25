package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int max=0;
        int min = Integer.MAX_VALUE;
        ArrayList<String> list = new ArrayList<String>();//напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line);
        }
        reader.close();
        for (String line:list) {
            int size=line.length();
            if (size<min) min=size;
            if (size>max) max=size;
        }
        for (String line: list) {
            if (line.length()==max||line.length()==min){ System.out.println(line);break;}
        }
    }
}
