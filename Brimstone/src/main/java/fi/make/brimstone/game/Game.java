package fi.make.brimstone.game;

import fi.make.brimstone.gui.FrameInit;
//Controller class for the game logic, middle point between the logic and GUI
public class Game {

    private Map map;

    public Game() {
        map = new Map();

        FrameInit f = new FrameInit(map);
        f.run();
        
        
    }

}
