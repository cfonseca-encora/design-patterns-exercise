package oop.inheritance.core.display.generic;

import oop.inheritance.core.display.Display;
import oop.library.v240m.VerifoneV240mDisplay;

public class VerifoneV240mGenericDisplay implements Display {
    private VerifoneV240mDisplay display;

    private static VerifoneV240mGenericDisplay genericDisplay;

    @Override
    public void print(int x, int y, String message) {
        verifyInstance();
        display.print(x, y, message);
    }

    @Override
    public void clear() {
        verifyInstance();
        display.clear();
    }

    public static VerifoneV240mGenericDisplay getInstance() {
        if(genericDisplay == null)
            genericDisplay = new VerifoneV240mGenericDisplay();

        return genericDisplay;
    }

    private void verifyInstance() {
        if(display == null)
            display = new VerifoneV240mDisplay();
    }
}
