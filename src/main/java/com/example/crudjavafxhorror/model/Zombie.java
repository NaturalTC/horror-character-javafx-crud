package com.example.crudjavafxhorror.model;


import com.example.crudjavafxhorror.model.enums.Vulnerability;

import java.time.LocalDate;

/**
 * Class representing a Zombie character in the horror RPG game.
 * Zombies are vulnerable to fire and sunlight.
 */
public class Zombie extends HorrorCharacter {

    /**
     * Constructor for a Zombie character.
     * @param name name of the zombie
     * @param health health of the zombie
     */
    public Zombie(String name, int health, LocalDate date) {
        super(name, health, date);

        // Zombies are vulnerable to fire and sunlight
        setVulnerabilities(new Vulnerability[] {
                Vulnerability.FIRE,
                Vulnerability.SUNLIGHT
        });
    }

    /**
     * Flee method for the zombie.
     * Zombies are unable to flee.
     */
    @Override
    public void flee() {
        System.out.println(getName() + " zombie is to dumb to escape!\n");
    }

}
