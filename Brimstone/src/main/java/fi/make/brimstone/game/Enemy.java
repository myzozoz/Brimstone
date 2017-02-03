package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Variables;

public class Enemy extends MapObject {

    public Enemy(double x, double y) {
        super(x, y, Variables.ENEMY_IMAGE);
    }
}
