package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class CoursesRepositoryImpl implements Repository<Course, Integer>{
    public CoursesRepositoryImpl(String course, int i) {
    }

    @Override
    public void add(Course item) {

    }

    @Override
    public void update(Course item) {

    }

    @Override
    public void delete(Course item) {

    }

    @Override
    public Course getById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Course> getAll() {
        return null;
    }
}

