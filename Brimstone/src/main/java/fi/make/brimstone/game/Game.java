package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.gui.FrameInit;
import fi.make.brimstone.gui.Painter;
import fi.make.brimstone.gui.DirectionListener;
//Controller class for the game logic, middle point between the logic and GUI

/**
 *
 * @author make
 */
public class Game {

    private DirectionListener dl;
    private MapController map;
    private Painter p;
    private Player plr;
    private FrameInit f;
    private long lastFrame;

    /**
     *
     */
    public Game() {
        map = new MapController(dl);
        f = new FrameInit(map);
        dl = f.getDirectionListener();
        map.setDirectionListener(dl);
        f.run();
        p = f.getPainter();
        plr = map.getPlayer();
        loop();
    }

    private void loop() {
        long lastFrame = System.currentTimeMillis();

        while (update()) {
            p.repaint();
            try {
                Thread.sleep(5l);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean update() {
        long current = System.currentTimeMillis();
        long dTime = current - lastFrame;
        lastFrame = current;

        return map.mapUpdate(dTime);
    }
}
