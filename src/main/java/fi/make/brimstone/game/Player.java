package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;

public class Player extends MapObject {
    private Vector speed = new Vector(1.0, 1.0);

    public Player(int x, int y) {
        super(x, y, Variables.pImagePath);
        
    }

    public void updatePosition() {
        x += speed.x;
        y += speed.y;
    }
    
    
}
