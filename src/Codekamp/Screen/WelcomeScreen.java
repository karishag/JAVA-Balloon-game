package Codekamp.Screen;

import Codekamp.Demo;
import Codekamp.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.*;

public class WelcomeScreen extends Screen{

    public static Connection conn;
    public static JTable table;
    public static boolean tableVisible=false;

    public WelcomeScreen(){

        connection();

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:src/Codekamp/mydb2.sqlite");
            Statement stmt = conn.createStatement();
            if(Demo.p1 != null) {
                stmt.execute("Insert into `Player`(`Name`,`Score`) VALUES ('" + Demo.p1 + "',0)");
            }
        }
        catch (SQLException ex) {
            System.out.println("Something Wrong " + ex);
        }
    }
    public void draw(Graphics g){
        g.setColor(new Color(150, 230,255));
        g.fillRect(0,0, Demo.WIDTH,Demo.HEIGHT);

        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("HISTORY",30,30);
        g.drawString("PRESS ANY KEY TO CONTINUE",250,250);
        /*if(tableVisible){
            table.setBounds(100,100,500,500);
            table.setVisible(true);
            tableVisible = true;
        }*/

    }

    public void update(){


    }

    public void onMousePress(MouseEvent e,GamePanel p) {
        if(History.counter ==1){
            if (e.getX() > 20 && e.getX() < 100 && e.getY() > 20 && e.getY() < 65) {
                System.out.println("ghrr");
                //connection();
                tableVisible = true;
                try {
                    //Connection conn = DriverManager.getConnection("jdbc:sqlite:src/Codekamp/mydb2.sqlite");
                    Statement stmt = conn.createStatement();

                    ResultSet r = stmt.executeQuery("SELECT * FROM `Player`");
                    String rowData[][] = new String[50][3];
                    int i=0;
                    while(r.next()){

                        rowData[i][0] = r.getString("Id");
                        rowData[i][1] = r.getString("Name");
                        rowData[i][2] = r.getString("Score");

                        i++;
                    }
                    String columnNames[] = {"No", "Player Name", "Score"};
                    table = new JTable(rowData, columnNames);

                    //table.setBounds(100,100,500,500);
                    //p.add(table);
                    //table.setVisible(false);


                } catch (SQLException ex) {
                    System.out.println("Something Wrong " + e);
                }
                History ob = new History(table);
                History.counter = 0;
            }
        }

    }

    public static void connection(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("We need to download some extra stuff. ok/cancel");
            return;
        }
    }
    @Override
    public void onKeyPress(int keyCode) {

        GamePanel.currentScreen = new Stage1Screen();
    }
}
