import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PickCharacterPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private JButton KarlFranz;
    private JButton IkitKlaw;
    private JFrame enclosingFrame;
    public PickCharacterPanel(JFrame frame) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        KarlFranz = new JButton("Karl Franz");
        add(KarlFranz);
        KarlFranz.addActionListener(this);
        IkitKlaw = new JButton("Ikit Klaw");
        add(IkitKlaw);
        IkitKlaw.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Who would you like to play as?", 920, 30);
        IkitKlaw.setLocation(0, 500);
        KarlFranz.setLocation(0, 800);
    }

    // ----- KeyListener interface methods -----
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

    // ----- ActionListener interface methods -----
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == IkitKlaw) {
                MainFrame f = new MainFrame("Ikit Claw");
            } else if (button == KarlFranz) {
                MainFrame f = new MainFrame("Karl Franz");
            }
            enclosingFrame.setVisible(false);
        }
    }
}
