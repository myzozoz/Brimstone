package fi.make.brimstone.helpers;

import java.awt.event.KeyEvent;

/**
 * An enum containing all the possible keys and their Keycodes. Not currently in
 * use.
 *
 * @author make
 */
public enum Keys {

    /**
     * Up.
     */
    UP("Up", KeyEvent.VK_UP),
    /**
     * Down.
     */
    DOWN("Down", KeyEvent.VK_DOWN),
    /**
     * Left.
     */
    LEFT("Left", KeyEvent.VK_LEFT),
    /**
     * Right.
     */
    RIGHT("Right", KeyEvent.VK_RIGHT),
    /**
     * W.
     */
    W("W", KeyEvent.VK_W),
    /**
     * A.
     */
    A("A", KeyEvent.VK_A),
    /**
     * S.
     */
    S("S", KeyEvent.VK_S),
    /**
     * D.
     */
    D("D", KeyEvent.VK_D);

    Keys(String text, int key) {
        this.key = key;
        this.name = text;
    }
    private int key;
    private String name;

    /**
     * Key value getter.
     * @return Key ID number.
     */
    public int getKey() {
        return key;
    }

    /**
     * Key name getter.
     * @return Key name.
     */
    public String getName() {
        return name;
    }
}
