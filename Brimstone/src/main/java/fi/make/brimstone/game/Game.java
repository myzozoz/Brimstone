package fi.make.brimstone.game;

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
        map = new MapController();
        f = new FrameInit(map);
        f.run();
        dl = f.getDirectionListener();
        p = f.getPainter();
        plr = map.getPlayer();
        loop();
    }

    private void loop() {
        long lastFrame = System.currentTimeMillis();

        while (true) {
            long beginUpdateTime = System.currentTimeMillis();
            update();
//            System.out.println(plr.getSpeed());
            p.repaint();
            long endUpdateTime = System.currentTimeMillis();
            long dTime = endUpdateTime - beginUpdateTime;
            System.out.println("dTime: " + dTime);
            try {
                Thread.sleep(17l - dTime);
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
