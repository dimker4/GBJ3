package Lesson2_db;

import java.sql.*;

public class DBHandler {
    private Statement stmt;
    public Connection connection;

    public void connect() { // Соединяемся с базой
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect () {
        try {
            connection.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable () { // Создадим таблицу, если она еще не существует
        String sql = "CREATE TABLE IF NOT EXISTS students (\n" +
                "    id    INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    name  VARCHAR (100) NOT NULL,\n" +
                "    score INT\n" +
                ");";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insertIntoStudents (String name, int score) { // Будем возвращать количество вставленных строк
        try {
            String sql = "INSERT INTO students (name, score) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql); // Сделаем подготовленный запрос
            ps.setString(1, name);
            ps.setInt(2, score);

            int rows = ps.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateScoreStudents (String name, int score) { // Будем возвращать количество обновленных строк
        try {
            String sql = "UPDATE students " +
                    "SET score = ? " +
                    "WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(sql); // Сделаем подготовленный запрос
            ps.setInt(1, score);
            ps.setString(2, name);

            int rows = ps.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteFromStudents (String name) { // Будем возвращать количество обновленных строк
        try {
            String sql = "DELETE FROM students " +
                    "WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(sql); // Сделаем подготовленный запрос
            ps.setString(1, name);

            int rows = ps.executeUpdate();
            return rows;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void dropTable () { // Создадим таблицу, если она еще не существует
        String sql = "DROP TABLE students";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStudents (String name) { // Создадим таблицу, если она еще не существует
        String sql = "SELECT name, score " +
                "FROM students " +
                "WHERE name = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql); // Сделаем подготовленный запрос
            ps.setString(1, name);

            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("name") + " " +rs.getString("score"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
