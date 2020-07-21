package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задания 1, 2
        String[] arrs = {"aa", "bb", "cc", "dd"};
        Integer[] arri = {1, 2, 3, 4, 5};
        ArrayList<String> myList;

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

        // Задание 3
        Box<Orange> boxOrange1 = new Box<Orange>();
        Box<Orange> boxOrange2 = new Box<Orange>();
        Box<Apple> boxApple1 = new Box<Apple>();
        Box<Apple> boxApple2 = new Box<Apple>();

        boxOrange1.add(new Orange(), new Orange(), new Orange(), new Orange()); //  4
        boxOrange2.add(new Orange(), new Orange(), new Orange(), new Orange(), new Orange()); // 5

        boxApple1.add(new Apple(), new Apple()); // 2
        boxApple2.add(new Apple(), new Apple(), new Apple(), new Apple(), new Apple(), new Apple()); // 6

        System.out.println(boxOrange1.getWeight()); // Получим веса коробок
        System.out.println(boxOrange2.getWeight());
        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple2.getWeight());

        System.out.println(boxApple2.compare(boxOrange1)); // Сравним вес коробок между собой
        System.out.println(boxApple1.compare(boxOrange2));

        boxApple1.shift(boxOrange1); // Пробуем пересывать фрукты из разных коробок
        boxApple1.shift(boxApple1);
        boxApple1.shift(boxApple2);

        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple2.getWeight());

    }
}


