package base.scene.overscene;

import base.GameObject;
import base.events.KeyEventPress;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import base.scene.SceneManager;
import base.scene.SceneStage1;

public class CoverGameOverScene extends GameObject {
    public CoverGameOverScene() {
        this.renderer = new SingleImageRenderer("assets/images/background/Over.png");
        this.position.set((int)Settings.SCREEN_WIDTH/2, (int)Settings.SCREEN_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if (KeyEventPress.isAnyKeyPress || KeyEventPress.isClicked) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
