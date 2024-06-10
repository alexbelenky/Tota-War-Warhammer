import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PickCharacterPanel extends JPanel implements MouseListener, MouseMotionListener {
    private BufferedImage backgroundIkit;
    private BufferedImage backgroundKarl;
    private Button KarlFranz;
    private Button IkitKlaw;
    private ArrayList<Button> buttons;
    private JFrame enclosingFrame;
    public PickCharacterPanel(JFrame frame) {
        try {
            backgroundIkit = ImageIO.read(new File("src/GUI/Background/ikitKlawBackground.png"));
            backgroundKarl = ImageIO.read(new File("src/GUI/Background/karlFranzBackground.png"));
            IkitKlaw = new Button("src/GUI/Buttons/ikitClawButton.PNG", 400, 400);
            KarlFranz = new Button("src/GUI/Buttons/karlFranzButton.PNG", 1425, 400);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        addMouseListener(this);
        addMouseMotionListener(this);
        buttons = new ArrayList<>(Arrays.asList(KarlFranz, IkitKlaw));

        for (Button button : buttons) {
            button.addMouseListener(button);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundIkit, 0, 0, null);
        g.drawImage(backgroundKarl, 950, 0, null);

        for (Button button : buttons) {
            if (button.isCustomVisible()) {
                g.drawImage(button.getImage(), (int) button.getxCoord(), (int) button.getyCoord(), null);
            }
        }

    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        Point mouseClickLocation = e.getPoint();
        for (Button button : buttons) {
            if (button.buttonRect().contains(mouseClickLocation) && button.isCustomVisible()) {
                if (button == KarlFranz) {
                    MainFrame f = new MainFrame("Karl Franz");
                    enclosingFrame.setVisible(false);
                } else if (button == IkitKlaw) {
                    MainFrame f = new MainFrame("Ikit Claw");
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

    // ----- MouseMotionListener interface methods -----

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        Point mouseLocation = e.getPoint();
        for (Button button : buttons) {
            if (button.buttonRect().contains(mouseLocation)) {
                button.setCustomVisible(true);
            } else {
                button.setCustomVisible(false);
            }
        }
        repaint();
    }
}
