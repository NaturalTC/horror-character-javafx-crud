package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.HorrorCharacter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class DashboardController {

    @FXML private Button btnCreate;
    @FXML private Button btnDelete;
    @FXML private Button btnUpdate;
    @FXML private ListView lstEntries;

    private ArrayList<HorrorCharacter> data;


    @FXML
    private void handleCreateClick(ActionEvent event) throws IOException {

        // Load the new FXML file
        Parent popupPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/crudjavafxhorror/popup-page.fxml")));
        Scene createCharacter = new Scene(popupPage);

        // Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set new scene
        stage.setScene(createCharacter);
        stage.setTitle("Create Horror Record");
        stage.setHeight(500);
        stage.setWidth(250);
        stage.isResizable();
        stage.show();
    }


}
