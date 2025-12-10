package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class PopupController implements Initializable {

    @FXML private TextField txtName;
    @FXML private TextField txtHealth;
    @FXML private RadioButton rbtnTransformed;
    @FXML private ComboBox<String> cmbCharacterType;
    @FXML private DatePicker dtePicker;

    //
    @FXML
    private void onSubmit(ActionEvent event) throws IOException {
        String name = txtName.getText();
        String type = cmbCharacterType.getValue();
        int health = Integer.parseInt(txtHealth.getText());
        LocalDate date = dtePicker.getValue();
        boolean transformed = rbtnTransformed.isSelected();

        // this was my debugging code i just left it in here why not
        System.out.printf("%s %s %d %s %b", type, name, health, date, transformed);

        /*
        I use an appState here pretty much as a singleton, everything is static and stored in one location (class)
        Based on the type instantiate an object of that Horror Character and add it into the ObservableList.
         */
        switch (type)
        {
            case "Werewolf":
                AppState.getState().addHorrorCharacter(new Werewolf(name, health, transformed, date));
                break;
            case "Vampire":
                AppState.getState().addHorrorCharacter(new Vampire(name, health, transformed, date));
                break;
            case "Zombie":
                AppState.getState().addHorrorCharacter(new Zombie(name, health, date));
                break;
        }
        returnToDashboard(event);
    }

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
        stage.setTitle("Horror Vault");
        stage.setWidth(1000);
        stage.setHeight(750);
        stage.isResizable();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // From book
        cmbCharacterType.setPromptText("Select a Horror Character");
        String[] horrorCharacters = {"Vampire", "Werewolf", "Zombie"};
        for (String hc : horrorCharacters)
        {
            cmbCharacterType.getItems().add(hc);
        }
    }
}
