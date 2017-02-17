package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Variables;

/**
 * 
 * @author make
 */
public class Enemy extends MapObject {

    /**
     *
     * @param x Initial x location.
     * @param y Initial y location.
     */
    public Enemy(double x, double y) {
        super(x, y, Variables.ENEMY_IMAGE);
    }
}
