package com.javarush.task.task22.task2208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
/*Map<String,String> map = new HashMap<String,String>();
map.put("name","Ivanov"); map.put("country",null); map.put("city","Kiev"); map.put("age", null);
        System.out.println(getQuery(map));*/

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder lineResult = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String,String> pair :params.entrySet()) {
            if ((pair.getKey()!=null)&&(pair.getValue()!=null)){
                StringBuilder line = new StringBuilder();
                line.append(pair.getKey()+" = '"+pair.getValue()+"'");
                list.add(line.toString());
            }
        }
        for (int i = 0; i <list.size() ; i++) {
            if (i!=(list.size()-1)){
                lineResult.append(list.get(i)+" and ");
            }else{
                lineResult.append(list.get(i));
            }
        }

        return lineResult.toString();
    }
}
