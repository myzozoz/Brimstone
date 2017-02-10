package fi.make.brimstone.helpers;

import java.awt.event.KeyEvent;

public class Key {

    private boolean pressed;
    private int key;
    private String name;

    public Key(String name, int key) {
        this.name = name;
        this.key = key;
        pressed = false;
    }

    public int getKey() {
        return key;
    }

    public String getKeyName() {
        return name;
    }

    public void press() {
        pressed = true;
//        System.out.println(name + " pressed");
    }

    public void release() {
        pressed = false;
//        System.out.println(name + "released");
    }

    public boolean isPressed() {
        return pressed;
    }
}
