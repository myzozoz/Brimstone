package fi.make.brimstone.helpers;

/**
 * Simple data container class, so that the game can always query, whether a
 * button has been pressed down, but not released.
 *
 * @author make
 */
public class Key {

    private boolean pressed;
    private int key;
    private String name;

    /**
     * Constructor initializes the class.
     * @param name Name of the key.
     * @param key The keys value.
     */
    public Key(String name, int key) {
        this.name = name;
        this.key = key;
        pressed = false;
    }

    /**
     * Key value getter.
     * @return Key value.
     */
    public int getKey() {
        return key;
    }

    /**
     * Key name getter.
     * @return Key name.
     */
    public String getKeyName() {
        return name;
    }

    /**
     * Called, when a KeyPressed event for a key of interest is received.
     */
    public void press() {
        pressed = true;
    }

    /**
     * Called when a KeyReleased event for a key of interest is received.
     */
    public void release() {
        pressed = false;
    }

    /**
     * The method called by the game itself, to see if a key is pressed.
     * @return The status of the key.
     */
    public boolean isPressed() {
        return pressed;
    }
}
