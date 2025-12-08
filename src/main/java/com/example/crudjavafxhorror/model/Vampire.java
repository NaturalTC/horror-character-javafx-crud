package com.example.crudjavafxhorror.model;


import com.example.crudjavafxhorror.model.enums.Vulnerability;
import com.example.crudjavafxhorror.model.interfaces.Transformable;

import java.time.LocalDate;


public class Vampire extends HorrorCharacter implements Transformable {
    // attributes
    private boolean transformed;

    // Constructor
    public Vampire(String name, int health, boolean transformed, LocalDate date) {
        super(name, health, date);

        // State to track transformation
        this.transformed = transformed;
        // Vampires are vulnerable to sunlight and holy water
        setVulnerabilities(new Vulnerability[]{
                Vulnerability.SUNLIGHT,
                Vulnerability.HOLY_WATER
        });
    }

    // ------------------------------------------------------------------------------

    public boolean getTransformed(){ return transformed; }


    @Override
    public void flee() {
        System.out.println(getName() + " escapes before the sunlight!\n");
    }

    @Override
    public void transform() {
        System.out.println(getName() + " has transformed into a Vampire Lord!\n");
    }
}
