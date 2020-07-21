package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class UltimateArray<T> {

    private T[] arr;
    private ArrayList<T> list;

    public UltimateArray(T[] arr) { // Создаем массив с любым ссылочным типом
        this.arr = arr;

    }

    public void swap (int firstPos, int secondPos) { // Метод изменения порядка, принимает на вход номера элементов в массиве
        T a = arr[firstPos];
        arr[firstPos] = arr[secondPos];
        arr[secondPos] = a;
    }

    public ArrayList<T> convertToList () { // Конвертируем массив в список
        list = new ArrayList<T>();
        list.addAll(Arrays.asList(arr));
        return list;
    }
}
