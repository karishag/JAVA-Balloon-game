package Codekamp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;

public class Demo implements MouseListener {

    private static Graphics g;
    public static Image balloon[] = new Image[8];
    public static Image pause,start,bomb,explosion;
    public static Random r;
    private static int xb,x1,x2,x3,x4,w1,w2,w3,w4,h1,h2,h3,h4,w,h,b1,b2,b3,b4,b5;
    public static int v,ball1Y = 900,ball2Y = 1050, ball3Y = 1200, ball4Y = 1350,bomb1y=1000,bomb2Y=1150,bomb3Y=1230;
    public static int score=0,bomb4Y=1340,bomb5Y=1450;
    public static boolean b1Visible=true,b2Visible=true,b3Visible=true,b4Visible=true;
    public static boolean gameOver=false,paused=false;
    private static AudioClip bhoom;
    private static AudioClip pop;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(600, 800));
        frame.add(p);
        frame.pack();
        frame.setVisible(true);

        p.setFocusable(true);
        Demo d1 = new Demo();
        //p.addKeyListener(d1);
        p.addMouseListener(d1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p.requestFocus();
        g = p.getGraphics();

        r = new Random();
        bhoom = Applet.newAudioClip(Demo.class.getClassLoader().getResource("codekamp/audio/bhoom.wav"));
        pop = Applet.newAudioClip(Demo.class.getClassLoader().getResource("codekamp/audio/pop.wav"));


        try {
            bomb = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/bomb.png"));
            explosion = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/explosion.png"));
            balloon[0] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon1.png"));
            balloon[1] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon2.png"));
            balloon[2] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon3.png"));
            balloon[3] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon4.png"));
            balloon[4] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon5.png"));
            balloon[5] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon6.png"));
            balloon[6] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon7.png"));
            balloon[7] = ImageIO.read(Demo.class.getClassLoader().getResource("codekamp/images/balloon8.png"));
            pause = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/images/pause.png"));
            start = ImageIO.read(Demo.class.getClassLoader().getResource("Codekamp/images/start.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        start();
    }

    public static void start(){

        gameOver=false;
        int vel=8;
        x1 = r.nextInt(450);
        x2 = r.nextInt(450);
        x3 = r.nextInt(450);
        x4 = r.nextInt(450);
        xb = r.nextInt(450);
        b1 = r.nextInt(450);
        b2 = r.nextInt(450);
        b3 = r.nextInt(450);
        b4 = r.nextInt(450);
        b5 = r.nextInt(450);
        Image balloon1,balloon2,balloon3,balloon4;
        v=r.nextInt(7);
        balloon1=balloon[v];
        v=r.nextInt(7);
        balloon2=balloon[v];
        v=r.nextInt(7);
        balloon3=balloon[v];
        v=r.nextInt(7);
        balloon4=balloon[v];
        while (true){
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(paused)
            {
                continue;
            }

            g.clearRect(0,0,600,800);

            ball1Y-= vel;       bomb1y-= 5;
            ball2Y-= vel;       bomb2Y-=5;
            ball3Y-= vel;       bomb3Y-=5;
            ball4Y-= vel;       bomb4Y-=5; bomb5Y-=5;

            if(score >=100 && score<200 )
            {
                vel=10;
            }
            else if(score>=200)
            {
                vel=15;
            }

            if(ball1Y < -20)
            {
                ball1Y = 880;
                x1 = r.nextInt(450);
                v=r.nextInt(7);
                balloon1=balloon[v];
                b1Visible = true;
            }
            if(ball2Y < -20)
            {
                ball2Y = 880;
                x2 = r.nextInt(450);
                v=r.nextInt(7);
                balloon2=balloon[v];
                b2Visible=true;
            }
            if(ball3Y < -20)
            {
                ball3Y = 880;
                x3 = r.nextInt(450);
                v=r.nextInt(7);
                balloon3=balloon[v];
                b3Visible=true;
            }
            if(ball4Y < -20)
            {
                ball4Y = 880;
                x4 = r.nextInt(450);
                v=r.nextInt(7);
                balloon4=balloon[v];
                b4Visible=true;
            }
            if(bomb1y < -20){
                b1=r.nextInt(450);
                bomb1y = 980;
            }
            if(bomb2Y < -20){
                b2=r.nextInt(450);
                bomb2Y = 980;
            }
            if(bomb3Y < -20){
                b3=r.nextInt(450);
                bomb3Y = 980;
            }
            if(bomb4Y < -20){
                b4=r.nextInt(450);
                bomb4Y = 980;
            }
            if(bomb5Y < -20){
                b5=r.nextInt(450);
                bomb5Y = 980;
            }

            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 10));
            g.drawString("SCORE = " + score, 500, 50);
            //System.out.println(score);
            w1 = balloon1.getWidth(null);
            h1 = balloon1.getHeight(null);
            if(b1Visible) {
                g.drawImage(balloon1, x1, ball1Y, null);
            }
            if(gameOver)
            {
                GameOver();
                break;
            }

            w2 = balloon2.getWidth(null);
            h2 = balloon2.getHeight(null);
            if(b2Visible) {
                g.drawImage(balloon2, x2, ball2Y, null);
            }
            w3 = balloon3.getWidth(null);
            h3 = balloon3.getHeight(null);
            if(b3Visible) {
                g.drawImage(balloon3, x3, ball3Y, null);
            }
            w4 = balloon4.getWidth(null);
            h4 = balloon4.getHeight(null);
            if(b4Visible) {
                g.drawImage(balloon4, x4, ball4Y, null);
            }

            w=bomb.getWidth(null);
            h=bomb.getHeight(null);

            g.drawImage(bomb,b1,bomb1y,null);

            g.drawImage(bomb,b2,bomb2Y,null);

            g.drawImage(bomb,b3,bomb3Y,null);

            g.drawImage(bomb,b4,bomb4Y,null);

            g.drawImage(bomb,b5,bomb5Y,null);

            g.drawImage(start,50,50,null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX() > x1 && e.getX() < x1+w1  && e.getY() > ball1Y && e.getY() < ball1Y+h1 && !paused )
        {
            pop.play();
            score+=10;
            b1Visible = false;
        }
        else if(e.getX() > x2 && e.getX() < x2+w2  && e.getY() > ball2Y && e.getY() < ball2Y+h2 && !paused )
        {
            score+=10; pop.play();
            b2Visible = false;
        }
        else if(e.getX() > x3 && e.getX() < x3+w3  && e.getY() > ball3Y && e.getY() < ball3Y+h3 && !paused )
        {
            score+=10;pop.play();
            b3Visible = false;
        }
        else if(e.getX() > x4 && e.getX() < x4+w4  && e.getY() > ball4Y && e.getY() < ball4Y+h4 && !paused  )
        {
            score+=10; pop.play();
            b4Visible = false;
        }
        else if(e.getX() > b1 && e.getX() < b1+w  && e.getY() > bomb1y && e.getY() < bomb1y+h && !paused )
        {
            gameOver = true;
        }
        else if(e.getX() > b2 && e.getX() < b2+w  && e.getY() > bomb2Y && e.getY() < bomb2Y+h && !paused )
        {
            gameOver = true;
        }
        else if(e.getX() > b3 && e.getX() < b3+w  && e.getY() > bomb3Y && e.getY() < bomb3Y+h && !paused )
        {
            gameOver = true;
        }
        else if(e.getX() > b4 && e.getX() < b4+w  && e.getY() > bomb4Y && e.getY() < bomb4Y+h && !paused )
        {
            gameOver = true;
        }
        else if(e.getX() > b5 && e.getX() < b5+w  && e.getY() > bomb5Y && e.getY() < bomb5Y+h && !paused )
        {
            gameOver = true;
        }
        if (e.getX() > 50 && e.getX() < 100 && e.getY() > 50 && e.getY() < 100) {
            Demo.paused = !Demo.paused;
            if(paused)
            {
                g.drawImage(pause,50,50,null);
            }
            else
            {
                g.drawImage(start,50,50,null);
            }
        }
    }

    public static void GameOver() {
        gameOver = true;
        bhoom.play();
        g.clearRect(0,0,600,800);
        g.drawImage(explosion, -30, -20, null);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Game Over \n Press any key to \ncontinue", 20, 100);

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
