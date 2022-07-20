package oop.inheritance.core.display.generic;

import oop.inheritance.core.display.Display;
import oop.library.ingenico.services.IngenicoDisplay;

public class IngenicoGenericDisplay implements Display {

    private IngenicoDisplay display;

    private static IngenicoGenericDisplay genericDisplay;
    @Override
    public void print(int x, int y, String message) {
        verifyInstance();
        display.showMessage(x, y, message);
    }

    @Override
    public void clear() {
        verifyInstance();
        display.clear();
    }

    public static IngenicoGenericDisplay getInstance() {
        if(genericDisplay != null)
            genericDisplay = new IngenicoGenericDisplay();

        return genericDisplay;
    }

    private void verifyInstance() {
        if(display == null)
            display = new IngenicoDisplay();
    }
}
