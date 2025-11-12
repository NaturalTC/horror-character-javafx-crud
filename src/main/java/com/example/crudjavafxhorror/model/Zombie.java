package com.example.crudjavafxhorror.model;


import com.example.crudjavafxhorror.enums.Vulnerability;

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
    public Zombie(String name, int health) {
        super(name, health);

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
        System.out.println(getName() + " is unable to flee!\n");
    }

}
