package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int mediana;
        if (array.length%2==0) {mediana = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else {mediana = array[array.length / 2]; }
        Arrays.sort(array,(x, y) ->Integer.compare(Math.abs(mediana-x), Math.abs(mediana-y)));
        return array;
    }
}
/*public class Solution {

    public static void main(String[] args) {
        *//*Integer[] array= {13, 8, 14, 5, 17, 19};
        sort(array);
        for (Integer in:array) {
            System.out.print(in+" - ");
        }*//*

    }

    public static Integer[] sort(Integer[] array) {
        int mediana;
        int number;
        Arrays.sort(array);//implement logic here
        if (array.length%2==0) {
            number = array.length / 2;
            mediana = (array[number] + array[number - 1]) / 2;
        } else {
            number = array.length / 2;
            mediana = array[number];
        }
        Comparator<Integer> comparatorInt = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(mediana-o1),Math.abs(mediana-o2));
            }
        };
        Arrays.sort(array,comparatorInt);
        return array;
    }
}*/
/*public class Solution {

    public static void main(String[] args) {
       *//* Integer[] array= {13, 8, 14, 5, 17, 19};
        sort(array);
        for (Integer in:array) {
            System.out.print(in+" - ");
        }*//*

    }

    public static Integer[] sort(Integer[] array) {
        int mediana;
        int number;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(array);//implement logic here
        if (array.length%2==0){
            number=array.length/2;
            mediana=(array[number]+array[number-1])/2;

            for (int i = 0; i <Integer.MAX_VALUE ; i++) {

                for (int j =0 ; j <number ; j++) {
                    int x=array[number-1-j];
                    int y=array[number+j];
                    if (x==mediana-i){
                        list.add(x);array[number-1-j]=Integer.MIN_VALUE;
                    }
                    if (y==mediana+i){
                        list.add(y);array[number+j]=Integer.MAX_VALUE;
                    }
                }
                if (list.size()==array.length)break;

            }
        }
        else {
            number=array.length/2;
            mediana=array[number];
            list.add(array[number]);
            array[number]=Integer.MIN_VALUE;
            for (int i = 1; i <Integer.MAX_VALUE ; i++) {

                for (int j =1 ; j <=number ; j++) {
                    int x=array[number-j];
                    int y=array[number+j];
                    if (x==(int)(mediana-i)){
                        list.add(x);array[number-j]=Integer.MIN_VALUE;
                    }
                    if (y==(int)(mediana+i)){
                        list.add(y);array[number+j]=Integer.MIN_VALUE;
                    }
                }
                if (list.size()==array.length)break;

            }
        }
        for (int i=0;i<list.size(); i++ ) {
            array[i]=list.get(i);
        }

        return array;
    }
}*/
