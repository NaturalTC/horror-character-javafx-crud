package com.example.crudjavafxhorror.controller;

import com.example.crudjavafxhorror.model.AppState;
import com.example.crudjavafxhorror.model.HorrorCharacter;
import com.example.crudjavafxhorror.model.Vampire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    // So this is where I connect my frontend
    @FXML private TableView<HorrorCharacter> tblHorrorCharacters;
    @FXML private TableColumn<HorrorCharacter, String> clmName;
    @FXML private TableColumn<HorrorCharacter, Integer> clmHealth;
    @FXML private TableColumn<HorrorCharacter, String> clmVulnerabilities;
    @FXML private TableColumn<HorrorCharacter, String> clmDate;

    // Here too
    @FXML private Button btnCreate;
    @FXML private Button btnDelete;
    @FXML private Button btnUpdate;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clmName.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("name"));
        clmHealth.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, Integer>("health"));
        clmVulnerabilities.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("vulnerabilities"));
        clmDate.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("date"));

        //Set up the columns to be editable
        tblHorrorCharacters.setEditable(true);
        clmName.setCellFactory(TextFieldTableCell.forTableColumn());
        clmHealth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        clmDate.setCellFactory(TextFieldTableCell.forTableColumn());
        tblHorrorCharacters.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Get data from the 'backend'
        tblHorrorCharacters.setItems(AppState.getState().getData());

    }
}
