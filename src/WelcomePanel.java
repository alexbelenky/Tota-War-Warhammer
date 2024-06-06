import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WelcomePanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    private BufferedImage background;
    private ArrayList<Button> buttons;
    private Button battleButton;
    private Button campaignButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button quitButton;
    private JFrame enclosingFrame;

    public WelcomePanel(JFrame frame) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/mainPage.png"));
            battleButton = new Button("src/GUI/Buttons/battleButton.png", 25, 530);
            campaignButton = new Button("src/GUI/Buttons/campaignButton.png", 30, 490);
            multiplayerButton = new Button("src/GUI/Buttons/multiplayerButton.png", 20, 570);
            optionsButton = new Button("src/GUI/Buttons/optionsButton.png", 30, 610);
            quitButton = new Button("src/GUI/Buttons/exitButton.png", 10, 900);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        buttons = new ArrayList<>(Arrays.asList(battleButton, campaignButton, multiplayerButton, optionsButton, quitButton));
        enclosingFrame = frame;
        addMouseListener(this);
        addMouseMotionListener(this);

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

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { } // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        Point mouseClickLocation = e.getPoint();
        for (Button button : buttons) {
            if (button.buttonRect().contains(mouseClickLocation) && button.isCustomVisible()) {
                if (button == campaignButton) {
                    PickCharacterFrame f = new PickCharacterFrame();
                    enclosingFrame.setVisible(false);
                } else if (button == optionsButton) {
                    SettingsFrame f = new SettingsFrame();
                } else if (button == quitButton) {
                    System.exit(0);
                }
            }
        }
    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    // ----- MouseMotionListener interface methods -----
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

    public void mouseDragged(MouseEvent e) { }
}