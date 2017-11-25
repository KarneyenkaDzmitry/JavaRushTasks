package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int p=10;
        do{
            int x =Integer.parseInt(reader.readLine());
            list.add(x);
        }while(--p>0);
        reader.close();
        int count = 1;
        int maxCount=1;
        for (int i=0; i<list.size()-1; i++) {

                if (list.get(i)==(list.get(i+1))) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }else {count=1;


            }
        }
        System.out.println(maxCount);
        //Это моё решение через два цикла
        /*count = 0;
        maxCount = 0;
        for (int i=0;i<list.size();i++){
            for (int j = i; j <list.size() ; j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    if (j==list.size()-1)count=0;

                }else{
                    count=0;break;
                }
            }
        }
        System.out.println(maxCount);*/
        //напишите тут ваш код

    }
}