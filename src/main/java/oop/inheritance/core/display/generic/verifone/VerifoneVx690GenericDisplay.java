package oop.inheritance.core.display.generic.verifone;

import oop.inheritance.core.display.Display;
import oop.library.vx690.VerifoneVx690Display;

public class VerifoneVx690GenericDisplay implements Display {

    private final VerifoneVx690Display display;

    private VerifoneVx690GenericDisplay() {
        display = new VerifoneVx690Display();
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
        private static final VerifoneVx690GenericDisplay genericDisplay = new VerifoneVx690GenericDisplay();
    }

    public synchronized static VerifoneVx690GenericDisplay getInstance() {
        return GenericDisplayHolder.genericDisplay;
    }
}
