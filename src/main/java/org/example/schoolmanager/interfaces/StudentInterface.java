package org.example.schoolmanager.interfaces;

import org.example.schoolmanager.models.Student;

import java.sql.SQLException;

public interface StudentInterface {
    public void create(Student student) throws SQLException;
    public Student read(int id);
    public void update(Student student);
    public void delete(int id);
}
