package com.example.crudjavafxhorror.model;

import com.example.crudjavafxhorror.model.enums.Vulnerability;
import com.example.crudjavafxhorror.model.interfaces.Transformable;

import java.time.LocalDate;

/**
 * Werewolf class, a type of HorrorCharacter that can transform into a human.
 * Werewolves are vulnerable to sunlight and silver.
 */
public class Werewolf extends HorrorCharacter implements Transformable {

    /**
     * Constructor
     * @param name name of the werewolf
     * @param health health of the werewolf
     */
    public Werewolf(String name, int health, boolean transformed, LocalDate date) {
        super(name, health, date);
        // State to track transformation

        // Werewolves are vulnerable to sunlight and silver
        setVulnerabilities(new Vulnerability[] {
                Vulnerability.SUNLIGHT,
                Vulnerability.SILVER
        });
    }

    /**
     * Flee method
     */
    @Override
    public void flee() {
        System.out.println(getName() + " haha escape NEVER!!!\n");
    }

    @Override
    public void transform() {
        System.out.println(getName() + " has transformed into a savage werewolf!\n");
    }


}
