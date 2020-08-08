package L5_multythread_synhr;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        CalcOperation oper;
        int a = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи первое число");
        int intX = sc.nextInt();
        System.out.println("Введи второе число");
        int intY = sc.nextInt();
        System.out.println("Введи операцию *, /, +, -");
        String str = sc.next();

        switch (str) {
            case "*": {
                oper = (x, y) -> x * y;
                System.out.println(oper.calculate(intX, intY));
                break;
            }
            case "/": {
                oper = (x, y) -> x / y;
                System.out.println(oper.calculate(intX, intY));
                break;
            }
            case "+": {
                oper = (x, y) -> x + y;
                System.out.println(oper.calculate(intX, intY));
                break;
            }
            case "-": {
                oper = (x, y) -> x - y;
                System.out.println(oper.calculate(intX, intY));
                break;
            }
        }
    }
}

interface CalcOperation {
    int calculate(int x, int y);
}
