package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("C:\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.txt");
        properties.list(System.out);//C:\JavaRushTasks\4.JavaCollections\src\com\javarush\task\task31\task3109\properties.txt

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        //Path path = Paths.get(fileName);
        //System.out.println(path.toString());
        //if (path.endsWith("task3109\\properties.xml"))
            //System.out.println(".xml");
        Properties properties = new Properties();
        if (fileName.endsWith(".xml")){
            try {
                FileInputStream fis = new FileInputStream(fileName);
                properties.loadFromXML(fis);
                fis.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }else{
            try {
                properties.load(new FileReader(new File(fileName)));
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
        return properties;
    }
}
