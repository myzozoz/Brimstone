package fi.make.brimstone.gui;

import fi.make.brimstone.game.MapObject;
import java.util.List;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fi.make.brimstone.game.Map;

public class FrameInit implements Runnable {

    private List<MapObject> l;
    private JFrame frame;
    private Map m;

    public FrameInit(Map m) {
        this.m = m;
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
        container.add(new Painter(m));
    }

    //Creates the initial dimensions for the screen, when it starts windowed
    private Dimension createInitialDimension() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        d.setSize(d.getWidth() * 0.75, d.getHeight() * 0.75);
        return d;
    }
}