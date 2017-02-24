package fi.make.brimstone.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Toolkit;

import fi.make.brimstone.game.MapController;
import fi.make.brimstone.helpers.Variables;

public class StatusBox extends JLabel {

    private MapController m;

    public StatusBox(String x, MapController m) {
        super(x);
        this.m = m;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String displayText = "";

        if (m.isPaused()) {
            displayText += "PAUSED";
        }

        setText(displayText);
        Toolkit.getDefaultToolkit().sync();
    }
}
