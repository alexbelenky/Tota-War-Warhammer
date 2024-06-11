import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DiplomacyEnemyPanel extends JPanel implements MouseListener, MouseMotionListener {
    private BufferedImage background;
    private Button exit;
    private Button leave;
    private ArrayList<Button> buttons;
    private JFrame enclosingFrame;
    private Diplomacy diplomacy; //will pick otherLord in gui

    public DiplomacyEnemyPanel(JFrame frame, Diplomacy diplomacy) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tradePanelBackground.png"));
            exit = new Button("src/GUI/Buttons/leaveButton.png", 19, 4);
            leave = new Button("src/GUI/Buttons/exitTradeButton.png", 1052, 1012);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        addMouseListener(this);
        addMouseMotionListener(this);
        this.diplomacy = diplomacy;
        buttons = new ArrayList<>(Arrays.asList(exit, leave));
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
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            Point mouseClickLocation = e.getPoint();
            System.out.println(e.getX() + "||" + e.getY());

            for (Button button : buttons) {
                if (button.buttonRect().contains(mouseClickLocation) && button.isCustomVisible()) {
                    if (button == exit) {
                        enclosingFrame.setVisible(false);
                    } else if (button == leave) {
                        enclosingFrame.setVisible(false);
                    }
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
