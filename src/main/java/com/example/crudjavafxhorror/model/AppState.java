package com.example.crudjavafxhorror.model;

import java.util.ArrayList;

public class AppState {

    private ArrayList<HorrorCharacter> data;
    private boolean currentRole;

    public AppState()
    {
        this.data = new ArrayList<>();
        this.currentRole = false;
    }
}
