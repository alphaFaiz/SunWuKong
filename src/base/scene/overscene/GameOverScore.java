package base.scene.overscene;

import base.GameObject;
import base.Score;
import base.game.Settings;
import base.renderer.TextRenderer;

import java.awt.*;

public class GameOverScore extends GameObject {
    public int highScore;
    public int yourScore;
    public GameOverScore(){
        super();
        this.yourScore = Score.value;
        this.highScore = Settings.HIGHSCORE;
        this.position.set(Settings.SCREEN_WIDTH/2 - 100, Settings.SCREEN_HEIGHT/2 +100);
        this.renderer = new TextRenderer("Your score: " + this.yourScore + "/nHigh score: " + this.highScore);
    }

    @Override
    public void run() {
        super.run();
        if (Settings.HIGHSCORE < yourScore){
            Settings.HIGHSCORE = this.yourScore;
            this.highScore = this.yourScore;
        }
        this.renderer = new TextRenderer("Your score: " + this.yourScore + "/nHigh score: " + this.highScore);

    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font(null,Font.BOLD,30));
        g.setColor(Color.GREEN);
        super.render(g);
    }
}
