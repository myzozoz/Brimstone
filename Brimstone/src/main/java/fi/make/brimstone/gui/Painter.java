package fi.make.brimstone.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;

import java.util.ArrayList;

import fi.make.brimstone.game.MapController;
import fi.make.brimstone.game.Player;
import fi.make.brimstone.game.MapObject;

public class Painter extends JPanel {
    private Dimension d;
    private Player plr;
    private MapController m;
    private Image plrImage;
    

    public Painter(MapController m, Dimension d) {
        super.setBackground(Color.GREEN);
        this.m = m;
        this.plr = m.getPlayer();
        plrImage = plr.getImage();
        this.d = d;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        System.out.println(d);
        
        //ALWAYS at index 0 is the LEVEL, and at index 1 the PLAYER
        //ArrayList<MapObject> items = (ArrayList) m.getAllObjects();
        
        for (MapObject mo : m.getAllObjects()) {
            g.drawImage(mo.getImage(), (int) (mo.getX() - plr.getX()) + (d.width / 2), (int) (mo.getY() - plr.getY() + (d.height / 2)), this);
        }
    }
    
    public void updateWindowSize(Dimension d){
        this.d = d;
    }
}
