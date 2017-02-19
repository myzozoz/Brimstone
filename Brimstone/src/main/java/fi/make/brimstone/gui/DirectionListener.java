package fi.make.brimstone.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import fi.make.brimstone.helpers.Key;
import fi.make.brimstone.helpers.Keys;


public class DirectionListener implements KeyListener {

    private HashMap<String, Key> keys;

    public DirectionListener() {
        keys = new HashMap();
        for (Keys k : Keys.values()) {
            keys.put(k.getName(), new Key(k.getName(), k.getKey()));
        }
    }

    public boolean noKeyPressed() {
        for (Key k : keys.values()) {
            if (k.isPressed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isKeyDown(String s) {
        return keys.get(s).isPressed();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode() + " pressed");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                //flame up
                break;
            case KeyEvent.VK_DOWN:
                //flame down
                break;
            case KeyEvent.VK_RIGHT:
                //flame right
                break;
            case KeyEvent.VK_LEFT:
                //flame.left
                break;
            case KeyEvent.VK_W:
                //move up
                keys.get("W").press();
                break;
            case KeyEvent.VK_A:
                //move left
                keys.get("A").press();
                break;
            case KeyEvent.VK_S:
                //move down
                keys.get("S").press();
                break;
            case KeyEvent.VK_D:
                keys.get("D").press();
                //move right
                break;
            default:
                
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e.getKeyCode() + " released");
        
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                //move up
                keys.get("W").release();
                break;
            case KeyEvent.VK_A:
                //move left
                keys.get("A").release();
                break;
            case KeyEvent.VK_S:
                //move down
                keys.get("S").release();
                break;
            case KeyEvent.VK_D:
                keys.get("D").release();
                //move right
                break;
        }
    }

}
