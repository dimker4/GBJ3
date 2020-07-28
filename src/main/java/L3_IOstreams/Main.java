package L3_IOstreams;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
//        // 1. Читаем файл в массив и выводим его на экран
//        try (FileInputStream in = new FileInputStream("test1.txt")){
//            int x;
//            byte[] arr = new byte[10];
//            while ((x = in.read(arr)) != -1) {
//                System.out.print(new String(arr, 0, x));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 2. Склеиваем несколько файлов
//        ArrayList<InputStream> ali = new ArrayList<>();
//        try {
//            ali.add(new FileInputStream("test1.txt"));
//            ali.add(new FileInputStream("test2.txt"));
//            ali.add(new FileInputStream("test3.txt"));
//
//            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(ali));
//            int x;
//
//            while ((x = in.read()) != -1) {
//                System.out.print((char) x);
//            }
//
//            in.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 3. Вводим номер страницы, получаем текст
//        PageNumberTask pn = new PageNumberTask(4);
//        pn.getPageText();
    }
}
