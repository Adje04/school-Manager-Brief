module org.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.schoolmanager to javafx.fxml;
    exports org.example.schoolmanager;

    opens org.example.schoolmanager.controllers to javafx.fxml;
    exports org.example.schoolmanager.controllers;

    opens org.example.schoolmanager.dbConfig to javafx.fxml;
    exports org.example.schoolmanager.dbConfig;

    opens org.example.schoolmanager.interfaces to javafx.fxml;
    exports org.example.schoolmanager.interfaces;

    opens org.example.schoolmanager.models to javafx.fxml;
    exports org.example.schoolmanager.models;

}