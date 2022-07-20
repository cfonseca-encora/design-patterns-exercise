package oop.inheritance.core.display.generic;

import oop.inheritance.core.display.Display;
import oop.library.vx520.VerifoneVx520Display;

public class Verifone520GenericDisplay implements Display {

    private VerifoneVx520Display display;

    private static Verifone520GenericDisplay genericDisplay;
    @Override
    public void print(int x, int y, String message) {
        verifyInstance();
        display.showMessage(message, x, y);
    }

    @Override
    public void clear() {
        verifyInstance();
        display.clear();
    }

    public static Verifone520GenericDisplay getInstance() {
        if(genericDisplay == null)
            genericDisplay = new Verifone520GenericDisplay();
        return genericDisplay;
    }

    private void verifyInstance() {
        if(display == null)
            display = new VerifoneVx520Display();
    }
}
