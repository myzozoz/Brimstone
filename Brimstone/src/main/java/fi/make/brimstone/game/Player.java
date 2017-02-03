package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;

public class Player extends MapObject {

    private Vector speed;

    public Player(int x, int y) {
        super(x, y, Variables.PLAYER_IMAGE);
        speed = Variables.PLAYER_SPEED;
    }

    public void updatePosition() {
        x += speed.x;
        y += speed.y;
    }

}
