package models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "Courses")
public class Course {
    public static final String[] courses = new String[]{"Разработчик Java", "Разработчик Python", "Разработчик C#",
            "Дизайнер с нуля до Junior", "Дизайнер интерьеров", "Разработчик искусственного интеллекта",
            "Интернет маркетолог", "Аналитик с нуля до Junior", "DevOps-инженер: быстрый старт в профессии"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course(){

    }

    public Course(String title, int duration) {

    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public static Course create() {
        Course course = new Course(null, 0);
        int number = random.nextInt(0, courses.length);
        String titleCourse = courses[number];
        int durationCourse = random.nextInt(9, 16);
        course.setTitle(titleCourse);
        course.setDuration(durationCourse);
        return course;
    }

    public void updateDuration() {
        duration = random.nextInt(8, 17);
    }

    public void updateTitle() {
        title = courses[random.nextInt(courses.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

}

