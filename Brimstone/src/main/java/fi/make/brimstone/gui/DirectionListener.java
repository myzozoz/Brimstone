package fi.make.brimstone.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import fi.make.brimstone.helpers.Key;
import fi.make.brimstone.helpers.Keys;
import fi.make.brimstone.helpers.FlameDirection;
import fi.make.brimstone.game.MapController;
import fi.make.brimstone.game.mapobjects.Player;


public class DirectionListener implements KeyListener {
    
    private HashMap<String, Key> keys;
    private MapController map;
    private Player player;

    public DirectionListener(MapController m) {
        this.map = m;
        player = m.getPlayer();
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
                player.setFlameDir(FlameDirection.UP);
                break;
            case KeyEvent.VK_DOWN:
                player.setFlameDir(FlameDirection.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                player.setFlameDir(FlameDirection.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                player.setFlameDir(FlameDirection.LEFT);
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
