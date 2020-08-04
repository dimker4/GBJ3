package L5_multythread_synhr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1); // Будем делать подготовку к гонке через CyclicBarrier
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        SynchronousQueue<Car> synQueue = new SynchronousQueue(); // Блокирующая очередь
        Car[] cars = new Car[CARS_COUNT];
        Thread[] arrThread = new Thread[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, synQueue);
        }
        for (int i = 0; i < cars.length; i++) {
            arrThread[i] = new Thread(cars[i]);
            arrThread[i].start();
        }
        try {
            cb.await(); // Тормознем основном поток до тех пор, пока все не будут готовы начать
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            // Пока в очередь не добавится 1 элемент, главный поток будет ждать, как только появился первый элемент
            // объявляем о победе и ждем завершения других потоков
            System.out.println(synQueue.take().getName() + " WIN!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Ожидаем заверешния всех потоков для вывода сообщения о завершении гонки
        for (int i = 0; i < CARS_COUNT; i++) {
            try {
                arrThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

class Car implements Runnable {
    private static int CARS_COUNT;
    CyclicBarrier cb;
    SynchronousQueue<Car> sc;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    // Будем передавть CyclicBarrier параметром
    public Car(Race race, int speed, CyclicBarrier cb, SynchronousQueue sc) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.sc = sc;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        sc.offer(this); // Добавим элемент в блокирующую очередь
    }
}

abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}

class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Tunnel extends Stage {
    Semaphore sm;
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        sm = new Semaphore(Main.CARS_COUNT / 2); // Ограничим проходную способность туннеля
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sm.acquire(); // Убираем 1 из симофора
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sm.release(); // Возвращаем 1 в симофор
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}

