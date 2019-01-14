package Codekamp;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

public class Resources {

    private static AudioClip bhoom;
    private static AudioClip pop;
    public static Image balloon[] = new Image[8];
    public static Image pause,start,bomb,explosion,background;

    public static void load(){
        bhoom = Applet.newAudioClip(Demo.class.getClassLoader().getResource("Codekamp/Resources/audios/bhoom.wav"));
        pop = Applet.newAudioClip(Demo.class.getClassLoader().getResource("Codekamp/Resources/audios/pop.wav"));


        try {
            bomb = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/bomb.png"));
            explosion = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/explosion.png"));
            balloon[0] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon1.png"));
            balloon[1] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon2.png"));
            balloon[2] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon3.png"));
            balloon[3] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon4.png"));
            balloon[4] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon5.png"));
            balloon[5] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon6.png"));
            balloon[6] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon7.png"));
            balloon[7] = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/balloon8.png"));
            pause = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/pause.png"));
            start = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/start.png"));
            background = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/Resources/images/background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static AudioClip getPop() {
        return pop;
    }

    public static Image[] getBalloon() {
        return balloon;
    }

    public static Image getPause() {
        return pause;
    }

    public static Image getStart() {
        return start;
    }

    public static Image getBomb() {
        return bomb;
    }

    public static Image getExplosion() {
        return explosion;
    }

    public static Image getBackground() {
        return background;
    }

    public static AudioClip getBhoom() {
        return bhoom;


    }
}

