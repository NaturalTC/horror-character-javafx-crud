package com.example.crudjavafxhorror.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class AppState {
    
    // Stores a static AppState object at the class level  
    private static final AppState appState = new AppState();
    
    // Creates a List that notifies the UI when updates have been made
    private final ObservableList<HorrorCharacter> data = FXCollections.observableArrayList();

    // This is my private constructor (singleton pattern) - prevents any new instances of AppState()
    private AppState() {
        getHorrorCharacters();
    }

    // Generate some data
    private void getHorrorCharacters()
    {
        data.add(new Vampire("Alucard", 50, false, LocalDate.now()));
        data.add(new Vampire("Stugar", 65, false, LocalDate.now()));
        data.add(new Vampire("Damian", 30, true, LocalDate.now()));
        data.add(new Vampire("Dracula", 100, true, LocalDate.now()));
        data.add(new Vampire("Barley", 55, false, LocalDate.now()));
    }


    // Getters / Adder
    public static AppState getState() {
        return appState;
    }

    public ObservableList<HorrorCharacter> getData() {
        return data;
    }

    public void addHorrorCharacter(HorrorCharacter character) {
        data.add(character);
    }
}

