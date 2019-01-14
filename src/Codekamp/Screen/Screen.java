package Codekamp.Screen;

import Codekamp.Demo;
import Codekamp.Entity.Entity;
import Codekamp.GamePanel;
import Codekamp.Resources;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
 public class Screen {

    protected List<Entity> entities = new ArrayList<>();

    public void update() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public void draw(Graphics g) {
        for (Entity e : entities) {
            if (e.visible) {
                g.drawImage(e.image, e.x, e.y, null);
            }
        }

    }

    public void onKeyPress(int keyCode) {

    }

    public void onMousePress(MouseEvent e, GamePanel p) {
    }
}
