package oop.inheritance.core.display.factory;

import oop.inheritance.core.display.Display;
import oop.inheritance.core.display.generic.IngenicoGenericDisplay;
import oop.inheritance.core.display.generic.Verifone520GenericDisplay;
import oop.inheritance.core.display.generic.Verifone690GenericDisplay;
import oop.inheritance.core.display.generic.VerifoneV240mGenericDisplay;
import oop.inheritance.core.keyboard.generic.Verifone520GenericKeyboard;
import oop.inheritance.data.SupportedTerminal;

public class DisplayFactory {
    public static Display getInstance(SupportedTerminal supportedTerminal) {
        return switch (supportedTerminal) {
            case INGENICO -> IngenicoGenericDisplay.getInstance();
            case VERIFONE_240_M -> VerifoneV240mGenericDisplay.getInstance();
            case VERIFONE_520 -> Verifone520GenericDisplay.getInstance();
            case VERIFONE_690 -> Verifone690GenericDisplay.getInstance();
        };
    }
}
