import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AttackPanel extends JPanel implements MouseListener, MouseMotionListener {
    private BufferedImage background;
    private Button exit;
    private Button autoResolve;
    private Button attack;
    private ArrayList<Button> buttons;
    private JFrame enclosingFrame;
    private Army userArmy;
    private Army otherArmy;

    public AttackPanel(JFrame frame, Army userArmy, Army otherArmy) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/attackBackground.png"));
            exit = new Button("src/GUI/Buttons/retreatButton.png", 1010, 1026);
            autoResolve = new Button("src/GUI/Buttons/autoResolveButton.png", 866, 1023);
            attack = new Button("src/GUI/Buttons/fightButton.png", 923, 994);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.userArmy = userArmy;
        this.otherArmy = otherArmy;

        buttons = new ArrayList<>(Arrays.asList(exit, autoResolve, attack));
        for (Button button : buttons) {
            button.addMouseListener(button);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        for (Button button : buttons) {
            if (button.isCustomVisible()) {
                g.drawImage(button.getImage(), (int) button.getxCoord(), (int) button.getyCoord(), null);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        Point mouseClickLocation = e.getPoint();
        System.out.println(mouseClickLocation.getX() + "||" + mouseClickLocation.getY());
        for (Button button : buttons) {
            if (button.buttonRect().contains(mouseClickLocation) && button.isCustomVisible()) {
                if (button == autoResolve) {
                    try {
                        background = ImageIO.read(new File("src/GUI/Background/deathScreen.png"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (button == exit) {
                    enclosingFrame.setVisible(false);
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

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
