package oop.inheritance.core.keyboard.generic.verifone;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class VerifoneV240mGenericKeyboard implements Keyboard {
    private final VerifoneV240mKeyboard keyboard;
    private static VerifoneV240mGenericKeyboard genericKeyboard;

    private VerifoneV240mGenericKeyboard() {
        keyboard = new VerifoneV240mKeyboard();
    }

    @Override
    public String getKey() {
        return keyboard.get();
    }

    public synchronized static VerifoneV240mGenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new VerifoneV240mGenericKeyboard();

        return genericKeyboard;
    }
}
