package com.example.crudjavafxhorror.model;

import com.example.crudjavafxhorror.enums.Vulnerability;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Arrays;
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

    /**
     * Constructor for a HorrorCharacter with health and optional mana.
     *
     * @param name   Name of the character.
     * @param health Initial health value.
     */
    public HorrorCharacter(String name, int health) {
        this.name = new SimpleStringProperty(name);
        this.health = new SimpleIntegerProperty(health);
        this.vulnerabilities = Vulnerability.values(); // default: all vulnerabilities
    }

    // ------------------------------------------------------------------------------

    public abstract void flee();

    // ------------------------------------------------------------------------------
    // Getters and Setters
    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setHealth(SimpleIntegerProperty health) {
        this.health = health;
    }

    public SimpleIntegerProperty getHealth() {
        return health;
    }

    public void setVulnerabilities(Vulnerability[] vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public SimpleStringProperty getVulnerabilities() {
        return new SimpleStringProperty(
                Arrays.stream(vulnerabilities)
                        .map(Enum::name)
                        .collect(Collectors.joining(", "))
        );
    }


}
