package oop.inheritance.core.abstractfactory.verifone;

import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.communicationdevices.factory.CommunicationDeviceFactory;
import oop.inheritance.core.display.Display;
import oop.inheritance.core.display.factory.DisplayFactory;
import oop.inheritance.core.abstractfactory.ITerminalFactory;
import oop.inheritance.core.keyboard.Keyboard;
import oop.inheritance.core.keyboard.factory.KeyboardFactory;
import oop.inheritance.core.printer.Printer;
import oop.inheritance.data.CommunicationType;
import oop.inheritance.data.SupportedTerminal;

public class VerifoneV240MTerminalFactory implements ITerminalFactory {
    private Display display;
    private Keyboard keyboard;
    private static CommunicationDevice communicationDevice;

    private VerifoneV240MTerminalFactory() {}

    public VerifoneV240MTerminalFactory(SupportedTerminal supportedTerminal, CommunicationType communicationType) {
        display = DisplayFactory.getInstance(supportedTerminal);
        keyboard = KeyboardFactory.getInstance(supportedTerminal);
        communicationDevice = CommunicationDeviceFactory.getInstance(supportedTerminal, communicationType);
    }

    @Override
    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public Display getDisplay() {
        return display;
    }

    @Override
    public CommunicationDevice getCommunicationDevice() {
        return communicationDevice;
    }

    @Override
    public Printer getPrinter() {
        return null;
    }
}
