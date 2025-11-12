package com.example.crudjavafxhorror.model;


import com.example.crudjavafxhorror.enums.Vulnerability;
import com.example.crudjavafxhorror.interfaces.Transformable;

import java.util.Random;

public class Vampire extends HorrorCharacter implements Transformable {

    // State to track transformation
    private boolean transformed = false;
    private final Random random = new Random();

    public Vampire(String name, int health) {
        super(name, health);

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
        if (getHealth() <= 0) {
            System.out.println(getName() + " you are dead! You cannot transform.\n");
        } else if (transformed) {
            System.out.println(getName() + " is transformed back into a vampire!\n");
            setName(getName().replace("Bat-", ""));
            setHealth(getHealth() + 10);
            transformed = false;
        } else {
            System.out.println(getName() + " transforms into a bat!\n");
            setName("Bat-" + getName());
            setHealth(getHealth() - 10);
            transformed = true;
        }
    }
}
