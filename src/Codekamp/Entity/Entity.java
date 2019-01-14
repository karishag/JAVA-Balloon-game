package Codekamp.Entity;

import Codekamp.Demo;
import Codekamp.Resources;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Entity {

    public int x;
    public int y;
    public int xVel = 0;
    public int yVel = 0;
    public int width;
    public int height;
    public Image image;
    public boolean visible = true;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(){
        this.x += this.xVel;
        this.y += this.yVel;

    }

    public void insideImage(MouseEvent e){

    }
    
}
