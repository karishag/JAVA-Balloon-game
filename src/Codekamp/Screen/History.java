package Codekamp.Screen;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class History implements WindowListener {
    JFrame f;
    public static int counter =1;
    public History(JTable table){
        f = new JFrame();
        //f.setLayout(null);
        table.setSize(400,400);
        table.getPreferredScrollableViewportSize();
        table.setEnabled(false);
        f.setAlwaysOnTop(true);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.addWindowListener(this);
        f.setBounds(250, 250,400,400);
        //f.setUndecorated(true);
        JScrollPane pane = new JScrollPane(table);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        f.add(pane);
        //f.add(table);
        f.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        counter = 1;
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
