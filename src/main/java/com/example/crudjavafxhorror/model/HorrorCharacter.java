package com.example.crudjavafxhorror.model;

import com.example.crudjavafxhorror.model.enums.Vulnerability;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Abstract base class for all horror characters.
 * Each character has a name, health, vulnerabilities, and mana.
 */
public abstract class HorrorCharacter {

    // Character attributes
    private SimpleStringProperty name;
    private SimpleIntegerProperty health;
    private Vulnerability[] vulnerabilities;
    private LocalDate date;

    /**
     * Constructor for a HorrorCharacter with health and optional mana.
     *
     * @param name   Name of the character.
     * @param health Initial health value.
     */
    public HorrorCharacter(String name, int health, LocalDate date) {
        this.name = new SimpleStringProperty(name);
        this.health = new SimpleIntegerProperty(health);
        this.vulnerabilities = Vulnerability.values(); // default: all vulnerabilities
        this.date = date;
    }

    // ------------------------------------------------------------------------------
    // abstract method
    public abstract void flee();

    // ------------------------------------------------------------------------------
    // Getters and Setters
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public String getName() { return name.get(); }

    public String getTableDate(){ return this.date.toString(); }

    public LocalDate getDate() { return this.date; }

    public void setHealth(SimpleIntegerProperty health) {
        this.health = health;
    }

    // This method is used to return the type of the class for my frontend UI
    public String getType() { return this.getClass().getSimpleName();}

    public void setType(String updatedCharter) {};

    public Integer getHealth() { return health.get(); }

    public void setVulnerabilities(Vulnerability[] vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public String getVulnerabilities() {
        return Arrays.stream(vulnerabilities)
                        .map(Enum::name)
                        .collect(Collectors.joining(", ")
        );
    }

    public void setDate(LocalDate updatedDate) {
        this.date = updatedDate;
    }
}
