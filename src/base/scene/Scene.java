package base.scene;

import javax.sound.sampled.Clip;

public abstract class Scene {
    public Clip sound;
    public abstract void init(); // abstract == public abstract
    public void clear(){
        this.sound.stop();
    };
}
