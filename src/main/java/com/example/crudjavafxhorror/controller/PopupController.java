package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PopupController implements Initializable {

    @FXML private TextField txtName;
    @FXML private TextField txtHealth;
    @FXML private RadioButton rbtnTransformed;
    @FXML private ComboBox<String> cmbCharacterType;

    // Handles AppState
    private AppState appState;

    // Event Handler - reminds me of Android Programming
    @FXML
    private void returnToDashboard(ActionEvent event) throws IOException {

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


    /* Ok, so my thought process is I need to store the role based on what has been selected for the submit so I can
        update the transformable button based on a boolean condition if it is possible.
     */
    @FXML
    private String returnRole(ActionEvent event)
    {
        return cmbCharacterType.getValue();
    }

    @FXML
    private void onSubmit(ActionEvent event) throws IOException {
        String name = txtName.getText();
        String type = cmbCharacterType.getValue();
        int health = Integer.parseInt(txtHealth.getText());
        boolean transformed = rbtnTransformed.isSelected();

        HorrorCharacter newHorrorCharacter;

        switch (type)
        {
            case ("Vampire"):
                newHorrorCharacter = new Vampire(name, health, transformed);
                break;
            case ("Werewolf"):
                newHorrorCharacter = new Werewolf(name, health, transformed);
                break;
            case ("Zombie"):
                newHorrorCharacter = new Zombie(name, health);
                break;
        }
        returnToDashboard(event);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCharacterType.setPromptText("Select a Horror Character");
        String[] horrorCharacters = {"Vampire", "Werewolf", "Zombie"};
        for (String hc : horrorCharacters)
        {
            cmbCharacterType.getItems().add(hc);
        }
    }
}
