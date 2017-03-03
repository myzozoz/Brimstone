package fi.make.brimstone.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

import fi.make.brimstone.game.MapController;
import fi.make.brimstone.game.mapobjects.Player;
import fi.make.brimstone.game.mapobjects.MapObject;

public class Painter extends JPanel {

    private Dimension d;
    private Player plr;
    private MapController m;

    public Painter(MapController m, Dimension d) {
        super.setBackground(Color.GREEN);
        this.m = m;
        this.plr = m.getPlayer();
        this.d = d;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MapObject mo : m.getAllObjects()) {
            g.drawImage(mo.getImage(), (int) (mo.getX() - plr.getX())
                    + (d.width / 2), (int) (mo.getY() - plr.getY() + (d.height / 2)), this);
        }

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Enemies alive: " + Integer.toString(m.getEnemyAmount()), d.width - 300, d.height - 100);
        g.drawString("Enemies killed: " + Integer.toString(m.getEnemiesKilled()), d.width - 300, d.height - 60);

        if (m.isPaused()) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.setColor(Color.RED);
            g.drawString("PAUSED", d.width / 2 - 100, d.height / 2);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    public void updateWindowSize(Dimension d) {
        this.d = d;
    }

}
