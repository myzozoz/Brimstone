package brimstone.game;

import java.util.List;
import java.util.ArrayList;

//Container class for all of the map objects
public class Map {

    private Player plr;

    public Map() {
        //Get the initial locations of all of the MapObjects that already exist
        //TEST
        plr = new Player(1, 2);
        //TEST
    }

    public List<MapObject> getAllObjects() {
        List<MapObject> l = new ArrayList();
        l.add(plr);
        return l;
    }
}
