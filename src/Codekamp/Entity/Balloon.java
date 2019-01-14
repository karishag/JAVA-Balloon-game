package Codekamp.Entity;

import Codekamp.Demo;
import Codekamp.Resources;

import java.awt.event.MouseEvent;

public class Balloon extends Entity {

    public static final int HEIGHT = 150;
    public static final int WIDTH = 110;
    public static int vel = -8;

    public Balloon(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    public void update() {
        this.yVel = vel;
        super.update();
    }

    public void insideImage(MouseEvent m){
        if (m.getX() > this.x && m.getX() < this.x + this.width && m.getY() > this.y && m.getY() < this.y + this.height && !Demo.paused) {
            Resources.getPop().play();
            Demo.score += 10;
            this.visible = false;
        }

    }

}
