package fi.make.brimstone.game;

import fi.make.brimstone.gui.FrameInit;
import fi.make.brimstone.gui.DirectionListener;
//Controller class for the game logic, middle point between the logic and GUI

public class Game {

    private DirectionListener dl;
    private Map map;

    public Game() {
        map = new Map();

        FrameInit f = new FrameInit(map);
        f.run();
        dl = f.getDirectionListener();
        loop();
    }

    private void loop() {
        while (true) {
            update();

            try {
                Thread.sleep(17);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void update() {

        if (dl.isKeyDown("W")) {
            System.out.println("W");
        }
    }
}
