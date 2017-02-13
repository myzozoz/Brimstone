package fi.make.brimstone.game;

import java.util.List;
import java.util.ArrayList;

//Container class for all of the map objects
public class Map {

    private Player plr;
    private List<Enemy> enms;
    private List<NCU> ncus;

    public Map() {
        enms = new ArrayList();
        ncus = new ArrayList();
        //Get the initial locations of all of the MapObjects that already exist
        //TEST
        plr = new Player(50, 50);
        enms.add(new Enemy(50, 100));
        enms.add(new Enemy(50, 150));
        ncus.add(new NCU(100, 200));
        ncus.add(new NCU(100, 300));
        ncus.add(new NCU(100, 400));
        //TEST
    }

    public List<MapObject> getAllObjects() {
        List<MapObject> l = new ArrayList();
        l.add(plr);
        l.addAll(enms);
        l.addAll(ncus);
        return l;
    }

    public void addEnemy(int x, int y) {
        enms.add(new Enemy(x, y));
    }

    public void addNCU(int x, int y) {
        ncus.add(new NCU(x, y));
    }

    public Player getPlayer() {
        return plr;
    }

    public List<Enemy> getEnemies() {
        return enms;
    }
}
