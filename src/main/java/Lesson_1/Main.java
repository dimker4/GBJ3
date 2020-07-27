package Lesson_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задания 1, 2
        String[] arrs = {"aa", "bb", "cc", "dd"};
        Integer[] arri = {1, 2, 3, 4, 5};
        ArrayList<Integer> myListi;

        System.out.println(Arrays.toString(arrs)); // Выведем исходный массив
        System.out.println(Arrays.toString(arri));

        swap(arri, 1, 2);
        swap(arrs, 1, 2);

        System.out.println(Arrays.toString(arrs)); // Выведем измененный массив
        System.out.println(Arrays.toString(arri));

        myListi = convertToList(arri); // Получаем список из массива
        System.out.println(myListi);

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

    public static <T> void swap(T[] arr, int firstPos, int secondPos) {
        T a = arr[firstPos];
        arr[firstPos] = arr[secondPos];
        arr[secondPos] = a;
    }

    public static<T> ArrayList<T> convertToList (T[] arr) { // Конвертируем массив в список
        ArrayList list = new ArrayList<T>();
        list.addAll(Arrays.asList(arr));
        return list;
    }
}
