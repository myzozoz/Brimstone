package fi.make.brimstone.gui;

import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fi.make.brimstone.game.MapController;
import fi.make.brimstone.game.MapObject;
import fi.make.brimstone.game.Player;
import java.awt.image.BufferStrategy;

public class FrameInit extends Canvas implements Runnable {

    private JFrame frame;
    private MapController m;
    private DirectionListener dl;
    private Painter p;
    private WindowResizeListener wrl;
    private Player plr;

    private Thread thread;

    public FrameInit(MapController m) {
        this.m = m;
        this.dl = new DirectionListener();
        this.wrl = new WindowResizeListener(this);
        this.plr = m.getPlayer();
    }

    @Override
    public void run() {
        frame = new JFrame("Brimstone");
        frame.setPreferredSize(createInitialDimension());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        frame.addKeyListener(dl);
        frame.addComponentListener(wrl);
        p = new Painter(m, frame.getContentPane().getSize());
        container.add(p);
    }

    //Creates the initial dimensions for the screen, when it starts windowed
    private Dimension createInitialDimension() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        d.setSize(d.getWidth() * 0.75, d.getHeight() * 0.75);
        return d;
    }

    public DirectionListener getDirectionListener() {
        return dl;
    }

    public Painter getPainter() {
        return p;
    }

    public void adjustToResize() {
        p.updateWindowSize(frame.getContentPane().getSize());
    }
}
