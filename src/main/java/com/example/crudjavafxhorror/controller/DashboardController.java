package com.example.crudjavafxhorror.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML private TableView<HorrorCharacter> tblHorrorCharacter;
    @FXML private TableColumn<HorrorCharacter, String> clmName;
    @FXML private TableColumn<HorrorCharacter, Integer> clmHealth;
    @FXML private TableColumn<HorrorCharacter, String> clmVulnerabilities;

    @FXML private Button btnCreate;
    @FXML private Button btnDelete;
    @FXML private Button btnUpdate;

    // ObserverList
    private ObservableList<HorrorCharacter> data= FXCollections.observableArrayList();

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
    
    // Generate some data
    public ObservableList<HorrorCharacter> getHorrorCharacters()
    {
        data.add(new Vampire("Alucard", 50, false));
        data.add(new Vampire("Stugar", 65, false));
        data.add(new Vampire("Damian", 30, true));
        data.add(new Vampire("Dracula", 100, true));
        data.add(new Vampire("Barley", 55, false));
        return data;
    }


    // Ok right now this stuff is like all jargon in my brain? What the hell is going on. (Look into reflection)
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clmName.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("name"));
        clmHealth.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, Integer>("health"));
        clmVulnerabilities.setCellValueFactory(new PropertyValueFactory<HorrorCharacter, String>("vulnerabilities"));

        //Set up the columns to be editable
        tblHorrorCharacter.setEditable(true);
        clmName.setCellFactory(TextFieldTableCell.forTableColumn());
        clmHealth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        clmVulnerabilities.setCellFactory(TextFieldTableCell.forTableColumn());

        tblHorrorCharacter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Get data from the 'backend'
        tblHorrorCharacter.setItems(getHorrorCharacters());
    }
}
