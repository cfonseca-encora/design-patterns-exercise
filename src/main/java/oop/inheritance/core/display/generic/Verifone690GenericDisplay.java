package oop.inheritance.core.display.generic;

import oop.inheritance.core.display.Display;
import oop.library.vx690.VerifoneVx690Display;

public class Verifone690GenericDisplay implements Display {

    private static Verifone690GenericDisplay genericDisplay;
    private VerifoneVx690Display display;

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

    public static Verifone690GenericDisplay getInstance() {
        if(genericDisplay == null)
            genericDisplay = new Verifone690GenericDisplay();
        return genericDisplay;
    }

    private void verifyInstance() {
        if(display == null)
            display = new VerifoneVx690Display();
    }
}
