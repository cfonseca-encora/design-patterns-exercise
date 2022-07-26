package oop.inheritance.core.display.generic.verifone;

import oop.inheritance.core.display.Display;
import oop.inheritance.core.display.generic.ingenico.IngenicoGenericDisplay;
import oop.library.v240m.VerifoneV240mDisplay;

public class VerifoneV240mGenericDisplay implements Display {
    private final VerifoneV240mDisplay display;

    private VerifoneV240mGenericDisplay() {
        display = new VerifoneV240mDisplay();
    }

    @Override
    public void print(int x, int y, String message) {
        display.print(x, y, message);
    }

    @Override
    public void clear() {
        display.clear();
    }

    private static final class GenericDisplayHolder {
        private static final VerifoneV240mGenericDisplay genericDisplay = new VerifoneV240mGenericDisplay();
    }

    public synchronized static VerifoneV240mGenericDisplay getInstance() {
        return GenericDisplayHolder.genericDisplay;
    }
}
