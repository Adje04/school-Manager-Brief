package org.example.schoolmanager.interfaces;

import org.example.schoolmanager.models.Classroom;
import org.example.schoolmanager.models.Student;

import java.sql.SQLException;

public interface ClassroomInterface {
    public void create(Classroom classroom) throws SQLException;
    public Classroom read(int id);
    public void update(Classroom classroom);
    public void delete(int id);
}
