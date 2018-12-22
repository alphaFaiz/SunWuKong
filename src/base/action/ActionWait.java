package base.action;

import base.FrameCounter;
import base.GameObject;

public class ActionWait implements Action {
    FrameCounter frameCounter;
    public ActionWait(int frameCount){
        this.frameCounter = new FrameCounter(frameCount);
    }

    @Override
    public boolean run(GameObject master) {
//        this.frameCounter.run();
        if(this.frameCounter.run()){
            return true;
        } else{
          return false;
        }
        //return false;
    }

    @Override
    public void reset() {
        this.frameCounter.reset();
    }
}
