package Codekamp;

import javax.swing.*;

public class Demo {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    public static int score = 0;
    public static String p1;
    public static boolean paused  = false;
    public static GamePanel g;

    public static void main(String[] args) {

        p1 = JOptionPane.showInputDialog("Enter player 1 name");
        System.out.println(p1);
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        g = new GamePanel();
        f.add(g);
        f.pack();
        f.setVisible(true);
    }
}
