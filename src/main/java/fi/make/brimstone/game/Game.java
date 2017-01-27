package fi.make.brimstone.game;

import java.util.*;
//Controller class for the game logic, middle point between the logic and GUI
public class Game {

    private Map map;
    
    public Game(){
        map = new Map();
        
        //TEST
        List<MapObject> l = map.getAllObjects();
        for (MapObject mo : l){
            System.out.println("Object: " + mo.getClass() + ", x: " + mo.getX() + ", y: " + mo.getY());
        }
        //TEST
    }
    
}
