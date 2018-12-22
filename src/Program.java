import base.game.GameCanvas;
import base.game.GameWindow;
import base.game.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        GameCanvas canvas = new GameCanvas();
        canvas.setPreferredSize(new Dimension((int)Settings.SCREEN_WIDTH, (int)Settings.SCREEN_HEIGHT));
        window.add(canvas);
        window.pack();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
        canvas.gameLoop();
    }
}
