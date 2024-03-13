package application;

import database.SchoolDB;
import database.DataBaseManager;
import models.Course;

import java.sql.SQLException;
import java.util.Random;


public class Main {
    /**
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */

    public static void main(String[] args) throws SQLException {

        SchoolDB schoolDB = new SchoolDB();
        DataBaseManager dataBaseManager = new DataBaseManager();
        Random random = new Random();


        // создание базы данных 'schoolDB' содержащую таблицу 'Courses' с полями (id, title, duration).
        SchoolDB.createDataBase(schoolDB);

        // Создание объекта
        Course course = DataBaseManager.addCourseToDataBase(DataBaseManager.openSession());

        // Изменение объекта
        dataBaseManager.updateCourse(course, DataBaseManager.openSession());

        // Чтение объекта
        // Предположим, мы хотим прочитать информацию о только что измененном курсе по его ID

        int idCourse = course.getId();
        Course retrivedCourse = dataBaseManager.getCourseByID(idCourse, DataBaseManager.openSession());
        System.out.println("Прочитаем из базы данных информацию об измененном курсе: - >");
        System.out.println(retrivedCourse);

        // Удаление объекта из базы
        dataBaseManager.removeCourse(course, DataBaseManager.openSession());
    }
}

