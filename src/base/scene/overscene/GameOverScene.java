package base.scene.overscene;

import base.GameObject;
import base.scene.Scene;
import tklibs.AudioUtils;

public class GameOverScene extends Scene {

    @Override
    public void init() {
        GameObject cover = GameObject.recycle(CoverGameOverScene.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/gameover.wav");
        this.sound.setFramePosition(0);
        this.sound.start();
        GameObject score = GameOverScore.recycle(GameOverScore.class);
    }

    @Override
    public void clear() {
        super.clear();
        GameObject.clearAll();
    }
}
