package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arrs = {"aa", "bb", "cc", "dd"};
        Integer[] arri = {1, 2, 3, 4, 5};
        ArrayList<String> myList = new ArrayList<String>();

        System.out.println(Arrays.toString(arrs)); // Выведем исходный массив
        System.out.println(Arrays.toString(arri));
        UltimateArray<String> ultArrs = new UltimateArray<String>(arrs); // Создадим новый экзмепляр с указанием Типа
        UltimateArray<Integer> ultArri = new UltimateArray<Integer>(arri); // Создадим новый экзмепляр с указанием Типа

        ultArrs.swap(0, 1); // Меняем местами
        ultArri.swap(3, 4);
        System.out.println(Arrays.toString(arrs)); // Выведем измененный массив
        System.out.println(Arrays.toString(arri));

        myList = ultArrs.convertToList(); // Получаем список из массива
        System.out.println(myList);
    }
}


