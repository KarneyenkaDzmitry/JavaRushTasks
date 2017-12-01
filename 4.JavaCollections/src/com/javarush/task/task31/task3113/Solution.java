package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.lang.System.exit;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.
Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:
Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]
Используй только классы и методы из пакета java.nio.
*/
public class Solution {

    private static int numberOfFolders=-1;
    private static int numberOfFiles=0;
    private static long countAllByted=0;


    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = reader.readLine();
    reader.close();
    Path path = Paths.get(line);
        class MyFileVisitor extends SimpleFileVisitor<Path>{
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countAllByted+=Files.size(file);
                numberOfFiles+=1;
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                numberOfFolders+=1;
                countAllByted+=Files.size(dir);
                return FileVisitResult.CONTINUE;
            }
        }
    if (Files.isDirectory(path)&&Files.exists(path)){


        try {
            Files.walkFileTree(path,new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Всего папок - "+numberOfFolders);
        System.out.println("Всего файлов - "+numberOfFiles);
        System.out.println("Общий размер - "+countAllByted);


    }else {
        System.out.println(path.toAbsolutePath()+" - не папка");

    }
    }
}

