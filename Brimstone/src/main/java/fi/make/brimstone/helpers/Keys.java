package fi.make.brimstone.helpers;

import java.awt.event.KeyEvent;

/**
 * An enum containing all the possible keys and their Keycodes. Not currently
 * in use.
 * @author make
 */
public enum Keys {

    /**
     *
     */
    UP("Up", KeyEvent.VK_UP),

    /**
     *
     */
    DOWN("Down", KeyEvent.VK_DOWN),

    /**
     *
     */
    LEFT("Left", KeyEvent.VK_LEFT),

    /**
     *
     */
    RIGHT("Right", KeyEvent.VK_RIGHT),

    /**
     *
     */
    W("W", KeyEvent.VK_W),

    /**
     *
     */
    A("A", KeyEvent.VK_A),

    /**
     *
     */
    S("S", KeyEvent.VK_S),

    /**
     *
     */
    D("D", KeyEvent.VK_D);

    Keys(String text, int key) {
        this.key = key;
        this.name = text;
    }
    private int key;
    private String name;

    /**
     *
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
