package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list=new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int length=list.get(0).length();
        for (int i = 1, l = list.size(); i <l ; i++) {
            if (length<list.get(i).length()){
                length=list.get(i).length();
            }else{
                System.out.println(i);
                break;
            }
        }
        //напишите тут ваш код
    }
}

