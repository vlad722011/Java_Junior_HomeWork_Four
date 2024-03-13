package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Создайте базу данных (например, SchoolDB).
 * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
 * Настройте Hibernate для работы с вашей базой данных.
 * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
 * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
 * Убедитесь, что каждая операция выполняется в отдельной транзакции.
 */

public class SchoolDB {

    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "admin";

    public SchoolDB(){

    }

    public SchoolDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS schoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }
    public static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL =  "USE schoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    public static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }


    public static void createDataBase(SchoolDB schoolDB) {
        try (Connection connection = DriverManager.getConnection(schoolDB.getUrl(), schoolDB.getUser(), schoolDB.getPassword())) {

            // Создание базы данных
            SchoolDB.createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            SchoolDB.useDatabase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            SchoolDB.createTable(connection);
            System.out.println("Create table successfully");

            // Закрытие соединения
            connection.close();
            System.out.println("Database connection close successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



