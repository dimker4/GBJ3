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

        // Задание 2
        MFU mfu = new MFU();
        HumanScan hs1 = new HumanScan(mfu, "Alice");
        HumanScan hs2 = new HumanScan(mfu, "Bob");
        HumanPrint hp1 = new HumanPrint(mfu, "John");
        HumanPrint hp2 = new HumanPrint(mfu, "Kate");
        HumanCopy hc1 = new HumanCopy(mfu, "Stan");
        HumanCopy hc2 = new HumanCopy(mfu, "Ivan");

        hs1.start();
        hs2.start();
        hp1.start();
        hp2.start();
        hc1.start();
        hc2.start();
    }
}
