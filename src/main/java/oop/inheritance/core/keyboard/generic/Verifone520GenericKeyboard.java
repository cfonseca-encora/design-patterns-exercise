package oop.inheritance.core.keyboard.generic;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.vx520.VerifoneVx520Keyboard;

public class Verifone520GenericKeyboard implements Keyboard {
    private VerifoneVx520Keyboard keyboard;
    private static Verifone520GenericKeyboard genericKeyboard;

    @Override
    public String getKey() {
        if(keyboard == null)
            keyboard = new VerifoneVx520Keyboard();

        return keyboard.get();
    }

    public static Verifone520GenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new Verifone520GenericKeyboard();

        return genericKeyboard;
    }
}
