package fi.make.brimstone.game;

import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.gui.StatusBox;
import fi.make.brimstone.gui.FrameInit;
import fi.make.brimstone.gui.Painter;
import fi.make.brimstone.gui.DirectionListener;
//Controller class for the game logic, middle point between the logic and GUI

/**
 * Umbrella class that works as the connecting layer between GUI and game logic.
 *
 * @author make
 */
public class Game {

    private DirectionListener dl;
    private MapController map;
    private Painter p;
    private StatusBox sb;
    private Player plr;
    private FrameInit f;
    private long lastFrame;

    /**
     * Entry point for the entire program. Calls the private loop()-function.
     * Initializes both graphics and game logic
     */
    public Game() {
        map = new MapController();
        f = new FrameInit(map);
        dl = f.getDirectionListener();
        map.setDirectionListener(dl);
        f.run();
        p = f.getPainter();
        sb = f.getStatusBox();
        plr = map.getPlayer();
        loop();
    }

    private void loop() {
        long lastFrame = System.currentTimeMillis();

        while (update()) {
            sb.repaint();
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
