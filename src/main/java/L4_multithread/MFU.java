package L4_multithread;

public class MFU {
    private Object scanLock = new Object();
    private Object printLock = new Object();

    public void scan (String name) {
        synchronized (scanLock) { // Делаем блокировку по сканеру
            System.out.println("Пользователь " + name + " сканирует документ");
            try {
                Thread.sleep(3000); // Ожидаем для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Пользователь " + name + " закончил сканировать документ");
        }
    }

    public void print (String name) {
        synchronized (printLock) { // Блокировка для контейнера с бумагой
            System.out.println("Пользователь " + name + " печатает документ");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Пользователь " + name + " закончил печатать документ");
        }

    }

    public void copy(String name) {
        // При копировании надо убедиться, что и принтер и сканер свободны
        synchronized (scanLock) {
            synchronized (printLock) {
                System.out.println("Пользователь " + name + " делает копию");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Пользователь " + name + " закончил делать копию");
            }
        }
    }
}
