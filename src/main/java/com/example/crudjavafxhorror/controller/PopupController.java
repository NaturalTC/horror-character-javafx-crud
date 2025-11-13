package com.example.crudjavafxhorror.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PopupController implements Initializable {

    @FXML private Label welcomeText;
    @FXML private ComboBox<String> cmbCharacterType;


    // Event Handler - reminds me of Android Programming
    @FXML
    private void handleCancelClick(ActionEvent event) throws IOException {

        // Load the new FXML file
        Parent rootPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/crudjavafxhorror/root-page.fxml")));
        Scene createCharacter = new Scene(rootPage);

        // Get current stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set new scene
        stage.setScene(createCharacter);
        stage.setTitle("Create Horror Record");
        stage.setWidth(1000);
        stage.setHeight(750);
        stage.isResizable();
        stage.show();
    }

    @FXML
    private void onSubmit(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Character Types that are loaded into the combo box
        cmbCharacterType.getItems().addAll("Vampire", "Werewolf", "Zombie");
    }
}
