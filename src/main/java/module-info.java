module com.example.crudjavafxhorror {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;


    opens com.example.crudjavafxhorror to javafx.fxml;
    exports com.example.crudjavafxhorror;
    exports com.example.crudjavafxhorror.controller;
    opens com.example.crudjavafxhorror.controller to javafx.fxml;
    exports com.example.crudjavafxhorror.model;
    opens com.example.crudjavafxhorror.model to javafx.fxml;
}