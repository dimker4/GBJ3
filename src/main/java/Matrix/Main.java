package Matrix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int SIZE = 5;
        int i = 0;
        int j = -1;
        int k = 0;
        int iter = 0;
        int order = 0;
        int[][] arr = new int[SIZE][SIZE];

        while (j < SIZE && k != 16) {
            while (j < (SIZE - 1 - iter)) {
                order = 1;
                j++;
                arr[i][j] = k;
                k++;
            }

            while (j == (SIZE-1-iter) && i < (SIZE - 1 - iter)) {
                order = 2;
                i++;
                arr[i][j] = k;
                k++;
            }

            if (i == (SIZE - 1 - iter)) {
                order = 3;
                while (j > 0 && k != SIZE*SIZE) {
                    j--;
                    arr[i][j] = k;
                    k++;
                }
            }

            while (i <= SIZE-1 && i > 0 && j == 0) {
                order = 4;
                i--;
                if (i != j) {
                    arr[i][j] = k;
                    k++;
                } else {
                    i++;
                    break;
                };
            }

            iter++;
        }

        for(int t = 0; t < SIZE; t ++) {
            System.out.println(Arrays.toString(arr[t]));
        }
    }
}
