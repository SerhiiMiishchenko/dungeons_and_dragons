package main.java;

import java.util.*;

class DndCharacter {
    private static final int DICE_COUNT = 4;
    private static final int DICE_SIDES = 6;
    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;
    private final String name;

    {
        constitution = generate();
    }

    DndCharacter(String name) {
        this.name = name;
        strength = modifier(generate());
        dexterity = modifier(generate());
        intelligence = modifier(generate());
        wisdom = modifier(generate());
        charisma = modifier(generate());
    }

    @Override
    public String toString() {
        return String.format("name: %s\n" +
                "strength: %d\n" +
                "dexterity: %d\n" +
                "constitution: %d\n" +
                "intelligence: %d\n" +
                "wisdom: %d\n" +
                "charisma: %d\n", name, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    private static int generate() {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int[] diceRolls = new int[DICE_COUNT];
        Random random = new Random();

        for (int i = 0; i < DICE_COUNT; i++) {
            diceRolls[i] = random.nextInt(DICE_SIDES) + 1;
            if (diceRolls[i] < min) min = diceRolls[i];
        }

        for (int i :
                diceRolls) {
            if (i > min) sum += i;
        }
        return sum;
    }

    private int modifier(int number) {
        int mod = (constitution - 10) / 2;
        return number - mod;
    }
}
