package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(modifiersOfThisClass);
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));
        System.out.println(Modifier.PUBLIC);//true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false
        System.out.println(Modifier.STATIC);
        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(modifiersOfMethod);
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {

        return ((allModifiers) & (specificModifier))>0 ? true : false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
