package Lesson2_db;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Задание 1
            DBHandler db = new DBHandler();
            db.connect();
            db.createTable();
            db.insertIntoStudents("Bob", 100);
            db.insertIntoStudents("John", 50);
            db.updateScoreStudents("John", 200);

            db.getStudents("Bob");

            db.deleteFromStudents("Bob");
            db.deleteFromStudents("John");

        //db.dropTable();

        //Задание 2
        File file = new File("test.txt");
        try {
            FileReader fr = new FileReader(file);
            // Построчно читаем файл
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            // Отключем автокоммит, для ускорения вставки
            db.connection.setAutoCommit(false);
            while (line != null) {
                System.out.println(line);
                // Бьем строку по пробелу
                String[] fields = line.split(" ");
                db.insertIntoStudents(fields[1], Integer.parseInt(fields[2]));
                line = reader.readLine();
            }
            // Вклчаем автокоммит
            db.connection.setAutoCommit(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();
    }
}
