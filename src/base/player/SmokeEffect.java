package base.player;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import base.events.MouseEventMotion;
import base.renderer.SmokeRenderer;

public class SmokeEffect extends GameObject {
    FrameCounter frameCounter;
    public SmokeEffect(){
        super();
        this.frameCounter = new FrameCounter(1);
        this.renderer = new SmokeRenderer("assets/images/smoke/cloud.png");
    }

    @Override
    public void run() {
        super.run();
        this.smaller();
        this.moveBehind();
    }

    private void moveBehind() {
        Vector2D toMouse = MouseEventMotion.getVectorFromCentorToMouse();
        Vector2D velocity2 = new Vector2D();
        if(toMouse.length() > 10) {
            velocity2.set(toMouse).setLength(speed).scaleThis(-1); //bullet's speed
        }
        else if (toMouse.length()<=10) {
            this.destroy();
        }

        this.velocity.set(velocity2);
    }
//xcvcv
    private void smaller() {
        SmokeRenderer smokeRenderer =(SmokeRenderer)this.renderer;
        if (this.frameCounter.run()){
            smokeRenderer.width -= 1;
            smokeRenderer.height -= 1;
            if (smokeRenderer.width == 0 || smokeRenderer.height == 0){
                this.destroy();
                smokeRenderer.width  = 32;
                smokeRenderer.height = 32;
            }
            this.frameCounter.reset();

        }
    }

}
