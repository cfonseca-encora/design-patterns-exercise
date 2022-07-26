package oop.inheritance.core.keyboard.generic.verifone;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.vx690.VerifoneVx690Keyboard;

public class VerifoneVx690GenericKeyboard implements Keyboard {

    private final VerifoneVx690Keyboard keyboard;
    private static VerifoneVx690GenericKeyboard genericKeyboard;

    private VerifoneVx690GenericKeyboard() {
        keyboard = new VerifoneVx690Keyboard();
    }

    @Override
    public String getKey() {
        return keyboard.get();
    }

    public synchronized static VerifoneVx690GenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new VerifoneVx690GenericKeyboard();

        return genericKeyboard;
    }

}
