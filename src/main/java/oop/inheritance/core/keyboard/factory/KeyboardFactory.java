package oop.inheritance.core.keyboard.factory;

import oop.inheritance.core.keyboard.Keyboard;
import oop.inheritance.core.keyboard.generic.ingenico.IngenicoGenericKeyboard;
import oop.inheritance.core.keyboard.generic.verifone.VerifoneVx520GenericKeyboard;
import oop.inheritance.core.keyboard.generic.verifone.VerifoneVx690GenericKeyboard;
import oop.inheritance.core.keyboard.generic.verifone.VerifoneV240mGenericKeyboard;
import oop.inheritance.data.SupportedTerminal;

public class KeyboardFactory {
    public static Keyboard getInstance(SupportedTerminal supportedTerminal) {
        return switch (supportedTerminal) {
            case INGENICO -> IngenicoGenericKeyboard.getInstance();
            case VERIFONE_240_M -> VerifoneV240mGenericKeyboard.getInstance();
            case VERIFONE_520 -> VerifoneVx520GenericKeyboard.getInstance();
            case VERIFONE_690 -> VerifoneVx690GenericKeyboard.getInstance();
        };
    }
}
