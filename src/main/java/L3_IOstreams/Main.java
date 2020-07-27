package L3_IOstreams;

import java.util.Arrays;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        int count = 0;
        count = (int) Arrays.stream(numbers).filter(o -> o > 0).count();

        System.out.println(count);
    }
}
