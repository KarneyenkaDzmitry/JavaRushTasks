package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Dzmitry");
            user.setLastName("Karneyenka");
            user.setBirthDate(new Date(1984,01,17));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);
            javaRush.users.add(user);
            User user0 = new User();
            //user0.setFirstName("Dzmitry0");
            //user0.setLastName("Karneyenka0");
            user0.setBirthDate(new Date(1984,01,17));
            user0.setMale(true);
            //user0.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user0);
            //System.out.println(user.getFirstName() + " " + user.getLastName() + " "+ user.getBirthDate().getTime() + " " +user.isMale() + " " + user.getCountry().getDisplayedName());
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (loadedObject.equals(javaRush)) System.out.println("they are the same");
            for (int i = 0; i <loadedObject.users.size() ; i++) {
                User user1 =loadedObject.users.get(i);
                System.out.println("User"+i+": "+user1.getFirstName() + " " + user1.getLastName() + " "+ user1.getBirthDate().getTime() + " " +user1.isMale() + " " + user1.getCountry().getDisplayedName());

            }

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter print = new PrintWriter(outputStream);//implement this method - реализуйте этот метод
            if (users.size()>0){
                print.println("yes");
                print.println(users.size());
                for (int i = 0; i<users.size(); i++) {


                        String line = users.get(i).getFirstName() + " " + users.get(i).getLastName() + " ";
                        if (users.get(i).getBirthDate()!=null){
                            line=line+users.get(i).getBirthDate().getTime() + " ";
                        }else line=line+"null ";
                          line=line+users.get(i).isMale()+" ";
                        if (users.get(i).getCountry()!=null){
                            line=line+users.get(i).getCountry().getDisplayedName();
                        }else line=line+"null";

                    print.println(line);

                }

            }else {print.println("no");}
            print.flush();
            print.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//implement this method - реализуйте этот метод
            String way = reader.readLine();
            if (way.equals("yes")){
                int size = Integer.parseInt(reader.readLine());


               for (int i = 0; i <size; i++) {
                    String nulOrLine=reader.readLine();
                        String mass[] = nulOrLine.split(" ");
                        User user = new User();
                   if (mass[0].equals("null")) {
                       user.setFirstName(null);
                   }else user.setFirstName(mass[0]);
                   if (mass[1].equals("null")) {
                       user.setLastName(null);
                   }else user.setLastName(mass[1]);
                   if (mass[2].equals("null")) {
                       Date date ;
                       date=null;
                       user.setBirthDate(date);
                   }else user.setBirthDate(new Date(Long.parseLong(mass[2])));
                   user.setMale(Boolean.parseBoolean(mass[3]));
                    //user.setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(mass[2]));
                   if (mass[4].equals("null")) {
                       user.setCountry(User.Country.OTHER);
                   }else {

                       switch (mass[4]) {
                           case ("Russia"):
                               user.setCountry(User.Country.RUSSIA);break;
                           case ("Ukraine"):
                               user.setCountry(User.Country.UKRAINE);break;
                           case ("Other"):
                               user.setCountry(User.Country.OTHER);break;
                       }
                   }

                        users.add(user);

                }

            }
            reader.close();

        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
