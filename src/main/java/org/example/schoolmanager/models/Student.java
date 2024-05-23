package org.example.schoolmanager.models;

import org.example.schoolmanager.dbConfig.IDBConnect;
import org.example.schoolmanager.interfaces.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student extends User implements StudentInterface {
    private int id;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String placeOfBirth;
    private int state = 0;
    private Classroom classroom;
    private Connection connection;

    public Student() {
        this.classroom = new Classroom();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getClassroomId() {
        return classroom.getId();
    }

    public void setClassroomId(int classroomId) {
        this.classroom.setId(classroomId);
    }

    @Override
    public void create(Student student) throws SQLException {
        connection = IDBConnect.getConnection();

        if (connection != null) {
            String query = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state, classroomId ) VALUES ( ?, ?, ?, ?, ?,?)";

            PreparedStatement prepareStatement = this.connection.prepareStatement(query);

            prepareStatement.setString(1, student.getFirstname());
            prepareStatement.setString(2, student.getLastname());
            prepareStatement.setString(3, student.getDateOfBirth());
            prepareStatement.setString(4, student.getPlaceOfBirth());
            prepareStatement.setInt(5, student.getState());
            prepareStatement.setInt(6, student.getClassroomId());
            int row = prepareStatement.executeUpdate();
            System.out.printf(String.valueOf(row));
            prepareStatement.close();
            this.connection.close();
            System.out.println("Eleve ajouté avec succès!");
        }
    }

    @Override
    public Student read(int id) {
        return null;
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
