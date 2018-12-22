package base.scene.menuscene;

import base.GameObject;
import base.scene.Scene;
import tklibs.AudioUtils;

import javax.sound.sampled.Clip;

public class MenuScene extends Scene {
    @Override
    public void init() {
        BackgroundMenuScene backgroundMenuScene = GameObject.recycle(BackgroundMenuScene.class);
        TextMenuScene textMenuScene = GameObject.recycle(TextMenuScene.class);
        //CoverMenuScene cover = GameObject.recycle(CoverMenuScene.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/openingSound.wav");
        this.sound.setFramePosition(0);
        this.sound.start();
//        StartButton startButton = GameObject.recycle(StartButton.class);
    }

    @Override
    public void clear() {
        super.clear();
        GameObject.clearAll();

    }
}
