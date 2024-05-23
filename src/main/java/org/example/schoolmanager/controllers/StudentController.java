package org.example.schoolmanager.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.schoolmanager.models.Student;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class StudentController {

    @FXML
    private TextField BirthDateTextField;

    @FXML
    private TextField BirthPlaceTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField studentClassTextField;

    @FXML
    void submitStudent() throws SQLException, ParseException {
        String firstname = firstnameTextField.getText().trim();
        String lastname = lastnameTextField.getText().trim();
        String dateOfBirthField = BirthDateTextField.getText().trim();
        String placeOfBirth = BirthPlaceTextField.getText().trim();
        String stateField = stateTextField.getText().trim();
        String classroomIdField = studentClassTextField.getText().trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (!firstname.isEmpty() && !lastname.isEmpty() && !dateOfBirthField.isEmpty() && !placeOfBirth.isEmpty() && !stateField.isEmpty() && !classroomIdField.isEmpty()) {
            Date dateOfBirth = dateFormat.parse(dateOfBirthField);
            String formattedDateOfBirth = sqlDateFormat.format(dateOfBirth);
            int state = Integer.parseInt(stateTextField.getText().trim());
            int classroomId = Integer.parseInt(studentClassTextField.getText().trim());

            Student student = new Student();

            student.setFirstname(firstname);
            student.setLastname(lastname);
            student.setDateOfBirth(String.valueOf(formattedDateOfBirth));
            student.setPlaceOfBirth(placeOfBirth);
            student.setState(state);
            student.setClassroomId(classroomId);

            student.create(student);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Added !");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to Add student...");
            alert.showAndWait();
        }

    }


}
