package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        //implement this method - реализуйте этот метод
        reader.close();
        FileInputStream fileReader = new FileInputStream(file);
        load(fileReader);
        fileReader.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream,"");
       //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
       Properties prop = new Properties();
       prop.load(inputStream);


        properties.putAll((Map)prop);


       //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception {
       /* Properties prop = new Properties();
        prop.setProperty("Dima","the best");
        prop.setProperty("Egor","great guy");
        prop.setProperty("Vadim","a man");
        prop.setProperty("Ilia","friend");
        FileOutputStream out = new FileOutputStream("d:/java/work/my.properties");
        prop.store(out,"my.properties");
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        out.close();
        //System.out.println(properties.get("Dima"));
    */
    }
}
