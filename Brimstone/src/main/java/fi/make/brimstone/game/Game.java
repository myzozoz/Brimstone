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

    /**
     * The game loop calls all the logic and GUI methods. 
     * <p>
     * It sleeps for 17 milliseconds, making the game run at approximately 
     * 60 frames per second. Functions it calls are for example Update
     * @see fi.make.brimstone.game.Game#update()
     * 
     * </p>
     */
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
