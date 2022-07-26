package oop.inheritance.core.display.factory;

import oop.inheritance.core.display.Display;
import oop.inheritance.core.display.generic.ingenico.IngenicoGenericDisplay;
import oop.inheritance.core.display.generic.verifone.VerifoneVx520GenericDisplay;
import oop.inheritance.core.display.generic.verifone.VerifoneVx690GenericDisplay;
import oop.inheritance.core.display.generic.verifone.VerifoneV240mGenericDisplay;
import oop.inheritance.data.SupportedTerminal;

public class DisplayFactory {
    public static Display getInstance(SupportedTerminal supportedTerminal) {
        return switch (supportedTerminal) {
            case INGENICO -> IngenicoGenericDisplay.getInstance();
            case VERIFONE_240_M -> VerifoneV240mGenericDisplay.getInstance();
            case VERIFONE_520 -> VerifoneVx520GenericDisplay.getInstance();
            case VERIFONE_690 -> VerifoneVx690GenericDisplay.getInstance();
        };
    }
}
