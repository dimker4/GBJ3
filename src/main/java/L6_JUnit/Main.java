package L6_JUnit;

public class Main {
    public static void main(String[] args) {
        ArrTask at = new ArrTask();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        at.getResult(arr);

        int[] arr2 = {1, 4, 1, 4, 1};
        System.out.println(at.checkExistsNumberArr(arr2));
    }
}
