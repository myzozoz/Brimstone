package fi.make.brimstone.helpers;

/**
 * Contains the values that are runtime constants. Confusingly named "Variables".
 * @author make
 */
public class Variables {

    public static final String PLAYER_IMAGE = "pic/Player.png";
    public static final String ENEMY_IMAGE = "pic/Enemy.png";
    public static final String WALL_IMAGE = "pic/Wall.png";
    public static final String LEVEL_0_IMAGE = "pic/level_0.png";
    public static final String FLAME_LEFT_IMAGE = "pic/flame_left_alt.png";
    public static final String FLAME_RIGHT_IMAGE = "pic/flame_right_alt.png";
    public static final String FLAME_UP_IMAGE = "pic/flame_up_alt.png";
    public static final String FLAME_DOWN_IMAGE = "pic/flame_down_alt.png";
    public static final String PAUSE_IMAGE = "pic/Pause.png";

    public static final Vector PLAYER_SPEED = new Vector(0, 0);
    public static final double PLAYER_MAX_SPEED = 2.0;
    public static final double ACCELERATION_MULTIPLIER = 0.001;
    public static final double DECELERATION_MULTIPLIER = 0.0001;
    
    public static final double ENEMY_DEFAULT_SPEED = 1.5;
    
}
