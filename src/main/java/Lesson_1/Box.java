package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> { // Ограничим только нашим родительским классом
    private ArrayList<T> list;

    public Box() {
        list = new ArrayList<T>();
    }

    public void add(T... fruit) { // Будем добавлять по несколько фруктов за раз
        list.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        if (list.size() > 0) { // Проверим, что в коробке что-нибудь лежит
            float weight = list.get(0).getWeight();
            return list.size() * weight;
        } else return 0;
    }

    public boolean compare (Box box) {
        return box.getWeight() == this.getWeight();
    }

    private T getFruit () { // Достаем фрукт из коробки
        return list.get(0);
    }

    public void shift (Box box) { // Передаем коробку в которую будем перекладывать фрукты
        if (box == this) {
            System.out.println("Надо пересыпать в другую коробку!");
            return;
        }
        if (box.getWeight() != 0) { // Если коробка не пустая, то проверим, что в ней лежит
            if (box.getFruit().getClass() == this.getFruit().getClass()) { //Сравниваем фрукт из другой коробки с фруктом в текущей коробке
                for (T fruit: list) { // Перекладываем по 1 фрукту
                    box.add(fruit);
                }
                System.out.println("Фрукты переложены!");
                this.list.clear(); // Очищаем коробку
            } else System.out.println("В коробках лежат разные фрукты");
        } else System.out.println("Коробка пустая!");
    }
}
