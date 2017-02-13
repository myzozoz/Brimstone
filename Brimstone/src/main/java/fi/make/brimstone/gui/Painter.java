package fi.make.brimstone.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

import fi.make.brimstone.game.Map;
import fi.make.brimstone.game.Player;
import fi.make.brimstone.game.MapObject;
import java.awt.Image;

public class Painter extends JPanel {

    private Player plr;
    private Map m;
    private Image plrImage;

    public Painter(Map m) {
        super.setBackground(Color.GREEN);
        this.m = m;
        this.plr = m.getPlayer();
        plrImage = plr.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MapObject mo : m.getAllObjects()) {
            g.drawImage(mo.getImage(), (int) mo.getX(), (int) mo.getY(), this);
        }
    }
}
