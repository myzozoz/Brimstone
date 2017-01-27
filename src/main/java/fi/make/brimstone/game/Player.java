package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;

public class Player extends MapObject {

    private Vector speed = new Vector(1.0, 1.0);

    public Player(int x, int y) {
        super(x, y);
        System.out.println("Player created");
    }

    public void updatePosition() {
        x += speed.x;
        y += speed.y;
    }
}
