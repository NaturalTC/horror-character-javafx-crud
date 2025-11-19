package com.example.crudjavafxhorror.model;

import com.example.crudjavafxhorror.enums.Vulnerability;
import com.example.crudjavafxhorror.interfaces.Transformable;

/**
 * Werewolf class, a type of HorrorCharacter that can transform into a human.
 * Werewolves are vulnerable to sunlight and silver.
 */
public class Werewolf extends HorrorCharacter implements Transformable {

    // State to track transformation
    private boolean transformed = false;

    /**
     * Constructor
     * @param name name of the werewolf
     * @param health health of the werewolf
     */
    public Werewolf(String name, int health, boolean transformed) {
        super(name, health);
        this.transformed = transformed;

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
        System.out.println(getName() + " tries to escape but fell on his face!\n");
    }

    @Override
    public void transform() {
        System.out.println(getName() + " has transformed into a savage werewolf!\n");
    }


}
