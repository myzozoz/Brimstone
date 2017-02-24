package fi.make.brimstone.helpers;

/**
 * Simple data container class, so that the game can always query, whether a button
 * has been pressed down, but not released.
 * @author make
 */
public class Key {

    private boolean pressed;
    private int key;
    private String name;

    /**
     *
     * @param name
     * @param key
     */
    public Key(String name, int key) {
        this.name = name;
        this.key = key;
        pressed = false;
    }

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
    public String getKeyName() {
        return name;
    }

    /**
     *
     */
    public void press() {
        pressed = true;
//        System.out.println(name + " pressed");
    }

    /**
     *
     */
    public void release() {
        pressed = false;
//        System.out.println(name + "released");
    }

    /**
     *
     * @return
     */
    public boolean isPressed() {
        return pressed;
    }
}
