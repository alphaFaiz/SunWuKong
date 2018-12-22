package base.events;

import base.Vector2D;
import base.game.Settings;

public class MouseEventMotion {
    public static Vector2D mousePosition = new Vector2D();

    public static Vector2D getVectorFromCentorToMouse() {
        return mousePosition.substract((int)Settings.SCREEN_WIDTH / 2,
                (int)Settings.SCREEN_HEIGHT / 2);
    }
}
