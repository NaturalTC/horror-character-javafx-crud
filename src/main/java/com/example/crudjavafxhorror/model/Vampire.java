package com.example.crudjavafxhorror.model;


import com.example.crudjavafxhorror.enums.Vulnerability;
import com.example.crudjavafxhorror.interfaces.Transformable;
import javafx.beans.property.SimpleStringProperty;

public class Vampire extends HorrorCharacter implements Transformable {

    // State to track transformation
    private boolean transformed = false;

    public Vampire(String name, int health, boolean transformed) {
        super(name, health);
        this.transformed = transformed;

        // Vampires are vulnerable to sunlight and holy water
        setVulnerabilities(new Vulnerability[]{
                Vulnerability.SUNLIGHT,
                Vulnerability.HOLY_WATER
        });
    }

    @Override
    public void flee() {
        System.out.println(getName() + " tries to escape but fell on his face!\n");
    }


    @Override
    public void transform() {
        System.out.println(getName() + " has transformed into a Vampire Lord!\n");
    }
}
