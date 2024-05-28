import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private boolean[] pressedKeys;
    private Timer timer;
    private int time;

    public GraphicsPanel(String name) {
        try {
            background = ImageIO.read(new File("")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        pressedKeys = new boolean[128];
        time = 0;
        timer = new Timer(1000, this); //1000ms = 1 second
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);  //

        // player moves left (A)
        if (pressedKeys[65]) {

        }

        // player moves right (D)
        if (pressedKeys[68]) {

        }

        // player moves up (W)
        if (pressedKeys[87]) {

        }

        // player moves down (S)
        if (pressedKeys[83]) {

        }
    }

    // ----- KeyListener interface methods -----
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            Point mouseClickLocation = e.getPoint();

        } else {
            Point mouseClickLocation = e.getPoint();

        }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

    // ----- ActionListener interface methods -----
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            time++;
        }
    }
}
