package fi.make.brimstone.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

import fi.make.brimstone.game.Map;
import fi.make.brimstone.game.MapObject;

public class Painter extends JPanel {

    private Map m;

    public Painter(Map m) {
        super.setBackground(Color.GREEN);
        this.m = m;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MapObject mo : m.getAllObjects()) {
            g.drawImage(mo.getImage(), (int) mo.getX(), (int) mo.getY(), this);
        }

    }
}
