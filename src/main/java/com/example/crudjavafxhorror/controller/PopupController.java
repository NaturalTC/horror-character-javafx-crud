package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.HorrorCharacter;
import com.example.crudjavafxhorror.model.Vampire;
import com.example.crudjavafxhorror.model.Werewolf;
import com.example.crudjavafxhorror.model.Zombie;
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

        // Character Types that are loaded into the combo box
        cmbCharacterType.getItems().addAll("Vampire", "Werewolf", "Zombie");
    }
}
