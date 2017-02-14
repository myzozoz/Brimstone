package fi.make.brimstone.game;

import fi.make.brimstone.gui.FrameInit;
import fi.make.brimstone.gui.Painter;
import fi.make.brimstone.gui.DirectionListener;
//Controller class for the game logic, middle point between the logic and GUI

public class Game {

    private DirectionListener dl;
    private MapController map;
    private Painter p;
    private Player plr;
    private FrameInit f;
    private long lastFrame;

    public Game() {
        map = new MapController();
        f = new FrameInit(map);
        f.run();
        dl = f.getDirectionListener();
        p = f.getPainter();
        plr = map.getPlayer();
        loop();
    }

    /**
     * The game loop calls all the logic and GUI methods.
     * <p>
     * It sleeps for 17 milliseconds, making the game run at approximately 60
     * frames per second. Functions it calls are for example Update
     *
     * @see fi.make.brimstone.game.Game#update()
     *
     * </p>
     */
    private void loop() {
        long lastFrame = System.currentTimeMillis();

        while (true) {
            update();
            System.out.println(plr.getSpeed());
            p.repaint();

            try {
                Thread.sleep(17);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void update() {
        long current = System.currentTimeMillis();
        long dTime = current - lastFrame;
        lastFrame = current;

        map.mapUpdate(dTime, dl);

        plr.updatePosition(dTime);
    }


}
