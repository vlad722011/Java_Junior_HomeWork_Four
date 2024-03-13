package database;

import models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseManager {

    public static Session openSession() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();
        System.out.println("open session successfully");
        return session;
    }

    public static Course addCourseToDataBase(Session session) {
        session.beginTransaction();
        System.out.println("open transaction successfully");
        Course course = Course.create();
        System.out.println("Object course save successfully");
        System.out.println(course.toString());
        session.save(course);
        session.getTransaction().commit();
        System.out.println("closed transaction successfully");
        return course;
    }

    public void updateCourse(Course course, Session session) {
        session.beginTransaction();
        System.out.println("open transaction successfully");
        course.setTitle("Новый курс");
        course.setDuration(25);
        session.update(course);
        session.getTransaction().commit();
        System.out.println("closed transaction successfully");
    }

    public Course getCourseByID(Integer ID, Session session) {
        session.beginTransaction();
        System.out.println("open transaction successfully");
        Course course = session.get(Course.class, ID);
        session.getTransaction().commit();
        System.out.println("closed transaction successfully");
        return course;
    }

    public void removeCourse(Course course, Session session) {
        session.beginTransaction();
        System.out.println("open transaction successfully");
        session.remove(course);
        System.out.println("object remove from database successfully");
        session.getTransaction().commit();
        System.out.println("closed transaction successfully");
    }

}