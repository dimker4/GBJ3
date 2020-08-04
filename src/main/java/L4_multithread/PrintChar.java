package L4_multithread;

public class PrintChar extends Thread{
    static char prevCh = 'c'; // Предыдущий символ делаем статическим, чт бы был общий для всех
    public char currCh;
    static Object lock = new Object(); // Объект блокировки

    public PrintChar(char c) {
        this.currCh = c;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i ++) {
            synchronized (lock) { // Используем синхронизацию по объекту
                while (prevCh != getPrevChar(this.currCh)) { // Проверяем предыдущий на корректность
                    try {
                        lock.wait(); // Если не корректный, то ожидаем
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // Если разбудили поток и вышли из цикла, значит он корректный
                System.out.print(currCh);
                System.out.println(" Меняем prevCh с " + prevCh + " на " + currCh);
                prevCh = currCh;
                lock.notifyAll(); // Будим все потоки
            }
        }
    }

    private char getPrevChar (char curr) {
        if (curr == 'a') return 'c';
        if (curr == 'b') return 'a';
        return 'b';
    }
}
