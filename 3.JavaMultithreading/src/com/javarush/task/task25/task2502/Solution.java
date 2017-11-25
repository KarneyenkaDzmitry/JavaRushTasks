package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            String[] array=loadWheelNamesFromDB();
            if (array.length==0||array==null||array.length<4||array.length>4){
             throw new Exception();
            }else {
                wheels=new ArrayList<Wheel>();
                for (String str : array) {

                    wheels.add(Wheel.valueOf(str));
                }
            }
            //Collections.addAll(wheels,Wheel.values());//init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
