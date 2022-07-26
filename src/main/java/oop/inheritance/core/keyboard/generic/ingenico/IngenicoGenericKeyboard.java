package oop.inheritance.core.keyboard.generic.ingenico;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.ingenico.services.IngenicoKeyboard;

public class IngenicoGenericKeyboard implements Keyboard {
    private final IngenicoKeyboard keyboard;

    private IngenicoGenericKeyboard() {
        keyboard = new IngenicoKeyboard();
    }

    @Override
    public String getKey() {
        return keyboard.getChar();
    }

    private static final class GenericKeyboardHolder {
        private static final IngenicoGenericKeyboard genericKeyboard = new IngenicoGenericKeyboard();
    }

    public static IngenicoGenericKeyboard getInstance() {
        return GenericKeyboardHolder.genericKeyboard;
    }
}
