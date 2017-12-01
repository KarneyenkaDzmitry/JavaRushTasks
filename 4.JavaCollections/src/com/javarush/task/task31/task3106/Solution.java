package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        if (args.length>2) {
            String resultFileName=args[0];
            args[0] = args[0] + ".000";
            Arrays.sort(args, (x, y) -> Integer.compare(Integer.parseInt(x.substring(x.lastIndexOf(".") + 1)), Integer.parseInt(y.substring(y.lastIndexOf(".") + 1))));
            Path pathResult = Paths.get(resultFileName);
            List<FileInputStream> list = new ArrayList<>();
            for (int i=1, n=args.length; i<n; i++) {
                list.add(new FileInputStream(args[i]));
            }
            SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(list));
            ZipInputStream zis = new ZipInputStream(sis);
            FileOutputStream fos = new FileOutputStream(resultFileName);
            byte[] buf = new byte[1024 * 1024];
            while (zis.getNextEntry() != null) {
                int count;
                while ((count = zis.read(buf)) != -1) {
                    fos.write(buf, 0, count);
                }
            }
            fos.close();
            zis.close();
            sis.close();

        }
    }
}
