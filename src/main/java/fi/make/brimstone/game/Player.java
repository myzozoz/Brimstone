package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Vector;

public class Player extends MapObject {

    private Vector speed;

    public Player(int x, int y) {
        super(x, y);
        System.out.println("Player created!");
    }

}
