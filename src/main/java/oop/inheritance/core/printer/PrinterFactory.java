package oop.inheritance.core.printer;

import oop.inheritance.core.printer.ingenico.IngenicoGenericPrinter;
import oop.inheritance.core.printer.verifone.VerifoneV240MGenericPrinter;
import oop.inheritance.core.printer.verifone.VerifoneVx520GenericPrinter;
import oop.inheritance.core.printer.verifone.VerifoneVx690GenericPrinter;
import oop.inheritance.data.SupportedTerminal;

public class PrinterFactory {
    public static Printer getInstance(SupportedTerminal supportedTerminal) {
        return switch (supportedTerminal) {
            case INGENICO -> IngenicoGenericPrinter.getInstance();
            case VERIFONE_240_M -> VerifoneV240MGenericPrinter.getInstance();
            case VERIFONE_520 -> VerifoneVx520GenericPrinter.getInstance();
            case VERIFONE_690 -> VerifoneVx690GenericPrinter.getInstance();
        };
    }
}
