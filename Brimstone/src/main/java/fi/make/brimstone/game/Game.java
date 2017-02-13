package fi.make.brimstone.game;

import fi.make.brimstone.gui.FrameInit;
import fi.make.brimstone.gui.Painter;
import fi.make.brimstone.gui.DirectionListener;
//Controller class for the game logic, middle point between the logic and GUI

public class Game {

    private DirectionListener dl;
    private Map map;
    private Painter p;
    private Player plr;
    private FrameInit f;
    private long lastFrame;

    public Game() {
        map = new Map();
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

        updatePlayer(dTime);

        plr.updatePosition(dTime);
    }

    private void updatePlayer(long dTime) {
        if (dl.isKeyDown("W") || dl.isKeyDown("S")) {
            if (dl.isKeyDown("W")) {
                plr.accelerate(0d, -1d, dTime);
            }
            if (dl.isKeyDown("S")) {
                plr.accelerate(0d, 1d, dTime);
            }
        } else {
            plr.decelerateVertical(dTime);
        }

        if (dl.isKeyDown("A") || dl.isKeyDown("D")) {
            if (dl.isKeyDown("A")) {
                plr.accelerate(-1d, 0d, dTime);
            }
            if (dl.isKeyDown("D")) {
                plr.accelerate(1d, 0d, dTime);
            }
        } else {
            plr.decelerateHorizontal(dTime);
        }
    }

}
