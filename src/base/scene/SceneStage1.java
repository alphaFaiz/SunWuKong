package base.scene;

import base.Score;
import base.background.Background;
import base.GameObject;
import base.enemysummoner.EnemySummoner;
import base.item.ItemGuide;
import base.item.ItemSummoner;
import base.item.Peach;
import base.physics.BoxCollider;
import base.player.Player;
import tklibs.AudioUtils;

public class SceneStage1 extends Scene {
    public GameObject background;
    public GameObject player;
    public EnemySummoner enemySummoner;
    public Score score;
//    public Peach peach;
    public ItemSummoner itemSummoner;
    public ItemGuide itemGuide;

    @Override
    public void init() {
        this.background = GameObject.recycle(Background.class); //new Background()
        this.player = GameObject.recycle(Player.class); //new Player()
        this.enemySummoner = GameObject.recycle(EnemySummoner.class);
        this.score = GameObject.recycle(Score.class);
        this.itemSummoner = GameObject.recycle(ItemSummoner.class);
        this.sound = AudioUtils.loadSound("assets/music/bgm/gameplay.wav");
        this.sound.setFramePosition(0);
        this.sound.start();
        this.sound.loop(100);
        //this.itemGuide = GameObject.recycle(ItemGuide.class);
    }

    @Override
    public void clear() {
        super.clear();
        GameObject.clearAll();
    }
}
