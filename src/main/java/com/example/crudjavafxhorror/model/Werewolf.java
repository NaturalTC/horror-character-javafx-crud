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

    /**
     * Transform method, toggles between werewolf and human forms.
     * Transforming into a human reduces health by 30, transforming back restores 30 health
     * if health is above 0.
     * If health is 0 or below, transformation is not possible.
     */
    @Override
    public void transform() {
        if (getHealth() <= 0) {
            System.out.println(getName() + " you are dead! You cannot transform.\n");
        } else if (transformed) {
            System.out.println(getName() + " is transformed back into a werewolf!\n");
            setName(getName().replace("Human Form - ", ""));
            setHealth(getHealth() + 30);
            transformed = false;
        } else {
            System.out.println(getName() + " transforms into a human!\n");
            setName("Human Form - " + getName());
            setHealth(getHealth() - 30);
            transformed = true;
        }
    }


}
