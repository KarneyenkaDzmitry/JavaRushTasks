package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();//D:\Java\Work\Task2209\Task2209.txt
        reader.close();
        StringBuilder line=new StringBuilder();
        BufferedReader readerFile = new BufferedReader(new FileReader(file));
        while(readerFile.ready()){
            line.append(readerFile.readLine()+" ");
        }
        readerFile.close();

        String words[] = (line.toString().trim()).split("\\s+");

        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
            if (words.length>0){
        List<String> list = new ArrayList<String>();

        Collections.addAll(list,words);
        /*for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }*/
            Collections.sort(list);

        /*for (int i = 0;i<list.size();i++) {
            System.out.println(list.get(i));
        }*/
        StringBuilder lineBuilder = new StringBuilder(list.get(0));
        list.remove(0);
        for (int i = 0; i <list.size() ; i++) {
            char ch =  lineBuilder.charAt(lineBuilder.length()-1);
            for (int j = i; j <list.size() ; j++) {
                char ch1 = (list.get(j).trim()).charAt(0);
                if(Character.toLowerCase(ch)==Character.toLowerCase(ch1)){
                    lineBuilder.append(" "+list.get(j));
                    list.remove(j);i--;
                    break;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            lineBuilder.append(" "+list.get(i));
        }
        return lineBuilder;
    }else return new StringBuilder();
    }
}
