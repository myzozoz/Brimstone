package brimstone.game;

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
        plr = new Player(1, 2);
        enms.add(new Enemy(2,3));
        enms.add(new Enemy(3,4));
        ncus.add(new NCU(4,5));
        ncus.add(new NCU(5,6));
        ncus.add(new NCU(6,7));
        //TEST
    }

    public List<MapObject> getAllObjects() {
        List<MapObject> l = new ArrayList();
        l.add(plr);
        l.addAll(enms);
        l.addAll(ncus);
        return l;
    }
}
