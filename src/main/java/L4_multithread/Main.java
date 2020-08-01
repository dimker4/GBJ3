package L4_multithread;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        PrintChar charA = new PrintChar('a');
        PrintChar charB = new PrintChar('b');
        PrintChar charC = new PrintChar('c');

        charA.start();
        charB.start();
        charC.start();
    }
}
