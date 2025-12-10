// github - https://github.com/NaturalTC/horror-character-javafx-crud

package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    /* Notes for myself
     - In the book they use alerts and Validation methods for different datatypes, I didnt handle that
     - I also didn't implement my Transformable Button, It doesnt do anything (ran out of time)
     -
     */

    // So this is where I connect my frontend
    @FXML private TableView<HorrorCharacter> tblHorrorCharacters;
    @FXML private TableColumn<HorrorCharacter, String> clmName;
    @FXML private TableColumn<HorrorCharacter, String> clmType;
    @FXML private TableColumn<HorrorCharacter, Integer> clmHealth;
    @FXML private TableColumn<HorrorCharacter, String> clmVulnerabilities;
    @FXML private TableColumn<HorrorCharacter, String> clmDate;

    // Changes to my other scene, unique temporary way of handling this in the controller
    @FXML
    private void createButtonClicked(ActionEvent event) throws IOException {

        // Load the new FXML file - Boiler plate google stuff
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

    // Boilerplate code used from the example
    @FXML
    public void deleteButtonPressed(ActionEvent event)
    {
        ObservableList<HorrorCharacter> allHorrorCharacters = tblHorrorCharacters.getItems();
        ObservableList<HorrorCharacter> selectedRows = tblHorrorCharacters.getSelectionModel().getSelectedItems();

        for(HorrorCharacter m : selectedRows)
        {
            allHorrorCharacters.remove(m);
        }
    }

    // Mostly boiler plate from the example
    // Ok right now this stuff is like all jargon in my brain? What the heck is going on? (Look into reflection)
    // Update: Okay I under stand the syntax stuff now. But I haven't gone down the rabbit hole.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        /* Notes on selection model
         - getSelectedItem() - returns the selected item
         - select(index)     - sets the selected item to the specified index
         */

        // This observable list stores the different types to choose from for the UI
        ObservableList<String> types = FXCollections.observableArrayList("Vampire", "Werewolf", "Zombie");

        clmName.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("name"));
        clmType.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("type"));
        clmHealth.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, Integer>("health"));
        clmVulnerabilities.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("vulnerabilities"));
        clmDate.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("TableDate")); // I had to create a custom tostring getter

        //Set up the columns to be editable
        tblHorrorCharacters.setEditable(true);
        clmName.setCellFactory(TextFieldTableCell.forTableColumn());
        clmHealth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        clmDate.setCellFactory(TextFieldTableCell.forTableColumn());

        // Used a combobox to keep the types strict to the child class names
        clmType.setCellFactory(ComboBoxTableCell.forTableColumn(types));

        tblHorrorCharacters.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        // OnClick Effects

        // Onclick for Type
        clmType.setOnEditCommit(event ->
        {
            HorrorCharacter currentCharacter = event.getRowValue();

            // This is for dubugging my code because it wont change objects
            System.out.println(currentCharacter);

            // The new character type
            String updatedType = event.getNewValue();

            // Update the type
            currentCharacter.setType(updatedType);

            String name = currentCharacter.getName();
            int health = currentCharacter.getHealth();
            LocalDate date = currentCharacter.getDate();

            // this was just easiest for handling the transformed part of the constructor
            boolean transformed = false;

            HorrorCharacter updatedCharacter = null;

            switch (updatedType)
            {
                case "Vampire":
                    updatedCharacter = new Vampire(name, health, transformed, date);
                    break;
                case "Werewolf":
                    updatedCharacter = new Werewolf(name, health, transformed, date);
                    break;
                case "Zombie":
                    updatedCharacter = new Zombie(name, health, date);
                    break;
            }
            int indexOfCharacter = AppState.getState().getData().indexOf(currentCharacter);
            AppState.getState().getData().set(indexOfCharacter, updatedCharacter);

            // Step 4: refresh table to force vulnerability update
            tblHorrorCharacters.refresh();
        });

        // OnClick for Name
        clmName.setOnEditCommit(event ->
        {
            HorrorCharacter currentCharacter = event.getRowValue();
            SimpleStringProperty updatedName = new SimpleStringProperty(event.getNewValue());

            currentCharacter.setName(updatedName);  // update the model
            tblHorrorCharacters.refresh();
        });

        // OnClick for Health
        clmHealth.setOnEditCommit(event ->
        {
            HorrorCharacter currentCharacter = event.getRowValue();
            SimpleIntegerProperty updatedHealth = new SimpleIntegerProperty(event.getNewValue());

            currentCharacter.setHealth(updatedHealth);
            tblHorrorCharacters.refresh();
        });

        // OnClick for Date
        clmDate.setOnEditCommit(event ->
        {
            HorrorCharacter currentCharacter = event.getRowValue();
            String updatedDate = event.getNewValue();
            try {
                // Convert string to a LocalDate
                LocalDate parsedDate = LocalDate.parse(updatedDate);

                // update the model
                currentCharacter.setDate(parsedDate);
                tblHorrorCharacters.refresh();
            }
            catch (Exception e) {
                tblHorrorCharacters.refresh();
            }
        });

        // Get data from the 'backend'
        tblHorrorCharacters.setItems(AppState.getState().getData());

    }
}
