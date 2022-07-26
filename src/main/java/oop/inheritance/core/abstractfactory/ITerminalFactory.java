package oop.inheritance.core.abstractfactory;

import oop.inheritance.core.card.provider.Provider;
import oop.inheritance.core.display.Display;
import oop.inheritance.core.communicationdevices.CommunicationDevice;
import oop.inheritance.core.keyboard.Keyboard;
import oop.inheritance.core.printer.Printer;

public interface ITerminalFactory {
    Keyboard getKeyboard();

    Display getDisplay();

    CommunicationDevice getCommunicationDevice();

    Printer getPrinter();

    Provider getCardProvider();
}
