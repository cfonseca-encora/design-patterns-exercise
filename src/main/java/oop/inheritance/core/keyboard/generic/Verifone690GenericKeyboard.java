package oop.inheritance.core.keyboard.generic;

import oop.inheritance.core.keyboard.Keyboard;
import oop.library.vx690.VerifoneVx690Keyboard;

public class Verifone690GenericKeyboard implements Keyboard {

    private VerifoneVx690Keyboard keyboard;
    private static Verifone690GenericKeyboard genericKeyboard;

    @Override
    public String getKey() {
        if(keyboard == null)
            keyboard = new VerifoneVx690Keyboard();

        return keyboard.get();
    }

    public static Verifone690GenericKeyboard getInstance() {
        if(genericKeyboard == null)
            genericKeyboard = new Verifone690GenericKeyboard();

        return genericKeyboard;
    }

}
