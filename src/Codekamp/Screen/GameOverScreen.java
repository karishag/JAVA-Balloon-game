package Codekamp.Screen;

import Codekamp.Demo;
import Codekamp.GamePanel;
import Codekamp.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GameOverScreen extends Screen {


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawImage(Resources.getExplosion(), 0, 0, null);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //g.setColor(Color.green);
        //g.fillRect(0, 0, Demo.WIDTH, Demo.HEIGHT);
        try {
            Statement stmt = WelcomeScreen.conn.createStatement();
            ResultSet r = stmt.executeQuery("SELECT * FROM `Player` WHERE `Name` = '" + Demo.p1 + "'");
            int previousScore = r.getInt("Score");
            if(Demo.score > previousScore)
            {
                stmt.execute("UPDATE `Player` Set `Score` = "+Demo.score+" WHERE `Name` = '" + Demo.p1 +"'");
            }

        } catch (SQLException ex) {
            System.out.println("Something Wrong " + ex);
        }

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Game Over", 200, 200);
        g.drawString("Your Score is " + Demo.score, 190, 223);
        g.drawString("Press enter to restart", 180, 246);
    }

    @Override
    public void onKeyPress(int keyCode) {
        if (keyCode == KeyEvent.VK_ENTER) {
            Demo.score = 0;
            GamePanel.currentScreen = new Stage1Screen();
        }
    }
}
