package org.example.schoolmanager.models;

import org.example.schoolmanager.dbConfig.IDBConnect;
import org.example.schoolmanager.interfaces.ClassroomInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Classroom implements ClassroomInterface {
    private int id;
    private String name;

    private Connection connection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void create(Classroom classroom) throws SQLException {
        connection = IDBConnect.getConnection();
        if (connection != null) {
            String query = "INSERT INTO classroom (name) VALUES ( ?)";

            PreparedStatement prepareStatement = this.connection.prepareStatement(query);

            prepareStatement.setString(1, classroom.getName());

            int row = prepareStatement.executeUpdate();
            System.out.printf(String.valueOf(row));
            prepareStatement.close();
            this.connection.close();
        }
    }

    @Override
    public Classroom read(int id) {
        return null;
    }

    @Override
    public void update(Classroom classroom) {

    }

    @Override
    public void delete(int id) {

    }
}
