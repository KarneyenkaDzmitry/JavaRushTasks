package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int array[] = new int[15];
        int count1=0, count2=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0, n = array.length; i < n; i++) {
            array[i]  = Integer.parseInt(reader.readLine());
        }
        for (int i = 0, n = array.length; i < n; i+=2) {
            count2+=array[i];
        }
        for (int i = 1, n = array.length; i < n; i+=2) {
            count1+=array[i];
        }
        if (count1>count2) System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println("В домах с четными номерами проживает больше жителей.");

        //напишите тут ваш код1
    }
}
