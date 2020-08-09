package L6_JUnit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class ArrTask {

    public int[] getResult(int[] arr)  {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (arr.length == 0) {
            try {
                throw new Exception("Массив пустой");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int[] result;
        int checkValue = 4; // Число для проверки по условию задачи
        int i = arr.length-1;
        while (arr[i] != checkValue) {
            if (i == 0) try {
                throw new Exception("В массиве нет " + checkValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultList.add(arr[i]);
            i--;
        }
        Collections.reverse(resultList);
        result = new int[resultList.size()];

        for (int j = 0; j < resultList.size(); j++) {
            result[j] = resultList.get(j);
        }

        return result;
    }

    public boolean checkExistsNumberArr (int[] arr) {
        if (arr.length == 0) {
            try {
                throw new Exception("Массив пустой");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long cnt = IntStream.of(arr).filter(f -> f != 4).filter(f -> f != 1).count();

        if (cnt > 0) {
            try {
                throw new Exception("В массиве присувтую цифры, отличные от 1 и 4");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        long cnt4 = IntStream.of(arr).filter(f -> f == 4).count();
        long cnt1 = IntStream.of(arr).filter(f -> f == 1).count();

        if (cnt4 > 0 && cnt1 > 0) return true;
        else return false;
    }
}
