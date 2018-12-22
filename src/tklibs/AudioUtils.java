package tklibs;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;



import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by huynq on 5/12/17.
 */
@SuppressWarnings("deprecation")
public class AudioUtils {

    /**
     * For playing sound effect: wav
     * @param audioUrl
     * @return
     */
    public static Clip loadSound(String audioUrl) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void initialize() {
//        new javafx.embed.swing.JFXPanel();
    }

//    public static void main(String[] args) {
//        Clip sound = loadSound("assets/music/sfx/enemy-explosion.wav");
//        long lastTime = 0;
//        while(true) {
//            long currentTime = System.currentTimeMillis();
//            if(currentTime - lastTime > 500) {
//                sound.setFramePosition(0);
//                sound.start();
//                lastTime = currentTime;
//            }
//        }
//    }

    /**
     * For playing background music, must calll intialize first: mp3
     * @param audioUrl
     * @return
     */

}
