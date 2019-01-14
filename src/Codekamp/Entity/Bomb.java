package Codekamp.Entity;

import Codekamp.Demo;
import Codekamp.GamePanel;
import Codekamp.Resources;
import Codekamp.Screen.GameOverScreen;

import java.awt.event.MouseEvent;

public class Bomb extends Entity{

    public static final int HEIGHT = 150;
    public static final int WIDTH = 110;
    public static int vel = -6;

    public Bomb(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }

    public void update() {
        this.yVel = vel;
        super.update();
    }

    public void insideImage(MouseEvent m){
        if (m.getX() > this.x && m.getX() < this.x + this.width && m.getY() > this.y && m.getY() < this.y + this.height && !Demo.paused) {
            Resources.getBhoom().play();
            GamePanel.currentScreen = new GameOverScreen();
            return;
        }

    }
}

