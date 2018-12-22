package base.game;

import base.Score;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Settings {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int SCREEN_WIDTH = (int)screenSize.getWidth();
    public static int SCREEN_HEIGHT = (int) screenSize.getHeight();
//    public static int SCREEN_WIDTH = 800;
//    public static int SCREEN_HEIGHT = 600;
    public static int BACKGROUND_WIDTH = 1600;
    public static int BACKGROUND_HEIGHT = 900;
    public static int UP_BUTTON = KeyEvent.VK_W;
    public static int DOWN_BUTTON = KeyEvent.VK_S;
    public static int LEFT_BUTTON = KeyEvent.VK_A;
    public static int RIGHT_BUTTON = KeyEvent.VK_D;
    public static int FIRE_BUTTON = KeyEvent.VK_SPACE;

    public final static int TOP = 0;
    public final static int BOT = 1;
    public final static int LEFT = 2;
    public final static int RIGHT = 3;
    public static int HIGHSCORE = Score.value;
}
