package fi.make.brimstone.game;

import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.Vector;

public class Level extends MapObject{
    
    
    public Level(double x, double y) {
        super(x, y, Variables.LEVEL_0_IMAGE);
    }
    
    public Vector getLevelDimensions(){
        return new Vector(image.getWidth(null), image.getHeight(null));
    }
    
}
