package oop.inheritance.core.keyboard.generic;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.ingenico.services.IngenicoKeyboard;

public class IngenicoGenericKeyboard implements Keyboard {
    private IngenicoKeyboard keyboard;
    private static IngenicoGenericKeyboard genericKeyboard;

    @Override
    public String getKey() {
        if(keyboard == null)
            keyboard = new IngenicoKeyboard();

        return keyboard.getChar();
    }

    public static IngenicoGenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new IngenicoGenericKeyboard();

        return genericKeyboard;
    }
}
