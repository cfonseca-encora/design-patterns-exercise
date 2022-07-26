package oop.inheritance.core.abstractfactory;

import oop.inheritance.core.abstractfactory.ingenico.IngenicoTerminalFactory;
import oop.inheritance.core.abstractfactory.verifone.VerifoneV240MTerminalFactory;
import oop.inheritance.core.abstractfactory.verifone.VerifoneVx520TerminalFactory;
import oop.inheritance.core.abstractfactory.verifone.VerifoneVx690TerminalFactory;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;

public class TerminalFactory {
    public static ITerminalFactory getInstance(SupportedTerminal supportedTerminal, CommunicationType communicationType) {
        return switch (supportedTerminal) {
            case INGENICO -> new IngenicoTerminalFactory(supportedTerminal, communicationType);
            case VERIFONE_240_M -> new VerifoneV240MTerminalFactory(supportedTerminal, communicationType);
            case VERIFONE_520 -> new VerifoneVx520TerminalFactory(supportedTerminal, communicationType);
            case VERIFONE_690 -> new VerifoneVx690TerminalFactory(supportedTerminal, communicationType);
        };
    }
}
