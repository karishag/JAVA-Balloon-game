package Codekamp;

import Codekamp.Screen.Screen;
import Codekamp.Screen.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements KeyListener,Runnable, MouseListener {
    public static Screen currentScreen;

    public GamePanel() {
        this.setPreferredSize(new Dimension(Demo.WIDTH, Demo.HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        this.requestFocus();

        Resources.load();
        GamePanel.currentScreen = new WelcomeScreen();

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.currentScreen.onKeyPress(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        Image bigImage = new BufferedImage(Demo.WIDTH, Demo.HEIGHT, BufferedImage.TYPE_INT_RGB);

        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            GamePanel.currentScreen.update();

            Graphics panelGraphics = this.getGraphics();
            Graphics imageGrahics = bigImage.getGraphics();


            imageGrahics.clearRect(0, 0, Demo.WIDTH, Demo.HEIGHT);
            GamePanel.currentScreen.draw(imageGrahics);
            imageGrahics.dispose();

            panelGraphics.drawImage(bigImage, 0, 0, null);
            panelGraphics.dispose();
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.currentScreen.onMousePress(e,this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
