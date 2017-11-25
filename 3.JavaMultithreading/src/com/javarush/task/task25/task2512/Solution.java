package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<String> list=new ArrayList<String>();
        while(e!=null){
            list.add(e.toString());
            e=e.getCause();
        }

        for (int i = list.size()-1; i >-1 ; i--) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread.setDefaultUncaughtExceptionHandler(solution);
        solution.uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
