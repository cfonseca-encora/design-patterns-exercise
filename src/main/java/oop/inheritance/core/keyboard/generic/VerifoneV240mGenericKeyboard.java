package oop.inheritance.core.keyboard.generic;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.v240m.VerifoneV240mKeyboard;

public class VerifoneV240mGenericKeyboard implements Keyboard {
    private VerifoneV240mKeyboard keyboard;
    private static VerifoneV240mGenericKeyboard genericKeyboard;

    @Override
    public String getKey() {
        if(keyboard == null)
            keyboard = new VerifoneV240mKeyboard();
        return keyboard.get();
    }

    public static VerifoneV240mGenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new VerifoneV240mGenericKeyboard();

        return genericKeyboard;
    }
}
