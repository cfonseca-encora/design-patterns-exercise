package oop.inheritance.core.keyboard.generic.verifone;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.vx520.VerifoneVx520Keyboard;

public class VerifoneVx520GenericKeyboard implements Keyboard {
    private final VerifoneVx520Keyboard keyboard;
    private static VerifoneVx520GenericKeyboard genericKeyboard;

    private VerifoneVx520GenericKeyboard() {
        keyboard = new VerifoneVx520Keyboard();
    }

    @Override
    public String getKey() {
        return keyboard.get();
    }

    public synchronized static VerifoneVx520GenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new VerifoneVx520GenericKeyboard();

        return genericKeyboard;
    }
}
