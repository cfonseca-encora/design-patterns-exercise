package oop.inheritance.core.display.generic.verifone;

import oop.inheritance.core.display.Display;
import oop.library.vx520.VerifoneVx520Display;

public class VerifoneVx520GenericDisplay implements Display {

    private final VerifoneVx520Display display;

    private VerifoneVx520GenericDisplay() {
        display = new VerifoneVx520Display();
    }

    @Override
    public void print(int x, int y, String message) {
        display.showMessage(message, x, y);
    }

    @Override
    public void clear() {
        display.clear();
    }

    private static final class GenericDisplayHolder {
        private static final VerifoneVx520GenericDisplay genericDisplay = new VerifoneVx520GenericDisplay();
    }

    public synchronized static VerifoneVx520GenericDisplay getInstance() {
        return GenericDisplayHolder.genericDisplay;
    }
}
