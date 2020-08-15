package Matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 10; // Размерность матрицы
        int i = 0;
        int j = -1; // -1 для корректного выполнения первого шага
        int k = 0; // Счетчик для заполнения матрицы
        int iter = 0; // Порядковый номер итерации
        int[][] arr = new int[SIZE][SIZE];

        // Общий цикл
        while (k < SIZE*SIZE) {
            // Цикл для заполнения шага вперед
            while (j < (SIZE - 1 - iter)) {
                j++;
                arr[i][j] = k;
                k++;
            }

            // Цикл для заполнения шага вниз
            while (j == (SIZE-1-iter) && i < (SIZE - 1 - iter)) {
                i++;
                arr[i][j] = k;
                k++;
            }

            if (i == (SIZE - 1 - iter)) { // Цикл для заполнения шага назад
                while (j > iter && k != SIZE*SIZE) {
                    j--;
                    arr[i][j] = k;
                    k++;
                }
            }

            // Цикл для заполнения шага вверх
            while (i <= SIZE-1 && i > iter && j == iter) {
                i--;
                if (i != j) {
                    arr[i][j] = k;
                    k++;
                } else {
                    i++;
                    break;
                };
            }

            // Считаем количество итераций
            iter++;
            // Выводим промежуточный итог после каждой итерации
            for(int t = 0; t < SIZE; t ++) {
                System.out.println(Arrays.toString(arr[t]));
            }
            System.out.println();
        }

        for(int t = 0; t < SIZE; t ++) {
            System.out.println(Arrays.toString(arr[t]));
        }
    }
}
