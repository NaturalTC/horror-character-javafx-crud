package com.example.crudjavafxhorror.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PopupController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
