package oop.inheritance.core.display.generic.ingenico;

import oop.inheritance.core.communicationdevices.verifone.modem.VerifoneVx690GenericModem;
import oop.inheritance.core.display.Display;
import oop.library.ingenico.services.IngenicoDisplay;

public class IngenicoGenericDisplay implements Display {

    private final IngenicoDisplay display;

    private IngenicoGenericDisplay() {
        display = new IngenicoDisplay();
    }
    @Override
    public void print(int x, int y, String message) {
        display.showMessage(x, y, message);
    }

    @Override
    public void clear() {
        display.clear();
    }

    private static final class GenericDisplayHolder {
        private static final IngenicoGenericDisplay genericDisplay = new IngenicoGenericDisplay();
    }

    public synchronized static IngenicoGenericDisplay getInstance() {
        return GenericDisplayHolder.genericDisplay;
    }
}
