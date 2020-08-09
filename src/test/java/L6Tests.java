import L6_JUnit.ArrTask;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class L6Tests {
    ArrTask at;

    @Before
    public void init() {
        at = new ArrTask();
    }

    @Test
    public void test1_1() {
        // Простая проверка
        int[] arr = {1, 2, 4, 5, 5, 6, 7, 1};
        int[] arrResult = {5, 5, 6, 7, 1};
        Assert.assertArrayEquals(arrResult, at.getResult(arr));
    }

    @Test
    public void test1_2() {
        // Много четверок
        int[] arr = {4, 2, 1, 5, 5, 6, 7, 1, 4, 2, 1, 5, 5, 6, 7, 1, 4, 2, 1, 5, 5, 6, 7, 1, 4, 2, 1, 5, 5, 6, 7, 1};
        int[] arrResult = {2, 1, 5, 5, 6, 7, 1};
        Assert.assertArrayEquals(arrResult, at.getResult(arr));
    }

    @Test
    public void test1_3() {
        // Четверка на последней позиции
        int[] arr = {1, 2, 4, 5, 5, 6, 7, 4};
        int[] arrResult = {};
        Assert.assertArrayEquals(arrResult, at.getResult(arr));
    }

    @Test
    public void test1_4() {
        // Все четверки
        int[] arr = {4, 4, 4, 4, 4};
        int[] arrResult = {};
        Assert.assertArrayEquals(arrResult, at.getResult(arr));
    }

    // Если возникнет исключение при пустом массиве, значит тест пройдет успешно
    @Test(expected = Exception.class)
    public void test1_5() {
        // Все пустой массив на вход
        int[] arr = {};
        int[] arrResult = {};
        Assert.assertArrayEquals(arrResult, at.getResult(arr));
    }

    @Test
    public void test2_1 () {
        int[] arr = {1, 1, 1, 4, 4, 4};
        Assert.assertTrue(at.checkExistsNumberArr(arr));
    }

    @Test
    public void test2_2 () {
        int[] arr = {1, 1, 1};
        Assert.assertFalse(at.checkExistsNumberArr(arr));
    }

    @Test
    public void test2_3 () {
        int[] arr = {4, 4, 4};
        Assert.assertFalse(at.checkExistsNumberArr(arr));
    }

    @Test(expected = Exception.class)
    public void test2_4 () {
        int[] arr = {1, 2, 3, 4, 5};
        Assert.assertTrue(at.checkExistsNumberArr(arr));
    }

}
