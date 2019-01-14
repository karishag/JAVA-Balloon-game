package Codekamp.Screen;

import Codekamp.Demo;
import Codekamp.Entity.Balloon;
import Codekamp.Entity.Bomb;
import Codekamp.Entity.Entity;
import Codekamp.GamePanel;
import Codekamp.Resources;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Codekamp.Resources.getBalloon;
import static Codekamp.Resources.getBomb;

public class Stage1Screen extends Screen {

    public static Entity b;
    private static final int GAP = 50;
    private static final int bound = Demo.WIDTH - 115;
    private static Random r = new Random();
    private List<Balloon> balloons = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();

    public Stage1Screen() {

        this.balloons.add(randomBalloon(900));
        this.balloons.add(randomBalloon(900 + 3 * 50));
        this.balloons.add(randomBalloon(900 + 6 * 50));
        this.balloons.add(randomBalloon(900 + 9 * 50));
        this.balloons.add(randomBalloon(900 + 12 * 50));

        this.bombs.add(bomb(1000));
        this.bombs.add(bomb(1000 + 4 * 40));
        this.bombs.add(bomb(1000 + 6 * 40));
        this.bombs.add(bomb(1000 + 8 * 40));

        this.entities.addAll(this.balloons);
        this.entities.addAll(this.bombs);

    }

    public void draw(Graphics g) {
        g.drawImage(Resources.getBackground(), 0, 0, null);
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("SCORE = " + Demo.score, Demo.WIDTH - 100,  50);
        super.draw(g);
    }

    public void update() {
        super.update();

        for (Balloon b : balloons) {
            if (b.y < -b.height) {
                b.y = Demo.HEIGHT + b.height - GAP - 30;
                b.x = r.nextInt(bound);
                b.visible = true;
            }
        }

        for (Bomb b : bombs) {
            if (b.y < -b.height) {
                b.y = Demo.HEIGHT + b.height - GAP;
                b.x = r.nextInt(bound);
                b.visible = true;
            }
        }

    }


    private Balloon randomBalloon(int y) {
        Balloon b = new Balloon(r.nextInt(bound), y);
        b.image = getBalloon()[r.nextInt(7)];

        return b;
    }

    private Bomb bomb(int y) {
        Bomb b = new Bomb(r.nextInt(bound), y);
        b.image = getBomb();
        return b;
    }

    public void onMousePress(MouseEvent m, GamePanel p) {
        for (Entity e : entities) {
            e.insideImage(m);
        }

    }

}
