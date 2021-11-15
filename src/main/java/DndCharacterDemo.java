package main.java;

public class DndCharacterDemo {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            DndCharacter character = new DndCharacter("Dragon" + i);
            System.out.println(character);
        }
    }
}
