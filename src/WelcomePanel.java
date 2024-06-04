import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//this will be changed to how the game looks like when you first start it
public class WelcomePanel extends JPanel implements MouseListener, ActionListener {
    private BufferedImage background;
    private ArrayList<Button> buttons;
    private Button battleButton;
    private Button campaignButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button quitButton;
    private JFrame enclosingFrame;
    boolean closed;

    public WelcomePanel(JFrame frame) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/mainPage.png"));
            battleButton = new Button("src/GUI/Buttons/battleButton.png", 25, 530, false);
            campaignButton = new Button("src/GUI/Buttons/campaignButton.png", 30, 490, false);
            multiplayerButton = new Button("src/GUI/Buttons/multiplayerButton.png", 20, 570, false);
            optionsButton = new Button("src/GUI/Buttons/optionsButton.png", 30, 610, false);
            quitButton = new Button("src/GUI/Buttons/exitButton.png", 10, 900, false);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        buttons = new ArrayList<>(Arrays.asList(battleButton, campaignButton, multiplayerButton, optionsButton, quitButton));
        enclosingFrame = frame;
        addMouseListener(this);
        closed = false;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        for(Button button : buttons) {
            if (!button.isVisible()) {
                g.drawImage(button.getImage(), (int) button.getxCoord(), (int) button.getyCoord(), null);
            }
        };
//
//        for (Button button : buttons) {
//            System.out.println(MouseInfo.getPointerInfo().getLocation().getX());
//            if (button.buttonRect().contains(MouseInfo.getPointerInfo().getLocation())) {
//                button.setVisible(true);
//            }
//        }
    }

    private Point getMouseLocation() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { } // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        Point mouseClickLocation = e.getPoint();
        System.out.println("hello");
        if(campaignButton.buttonRect().contains(mouseClickLocation)) {
            PickCharacterFrame f = new PickCharacterFrame();
            enclosingFrame.setVisible(false);
        } else if (optionsButton.buttonRect().contains(mouseClickLocation)) {
            SettingsFrame f = new SettingsFrame();
        } else if (quitButton.buttonRect().contains(mouseClickLocation)) {
            System.exit(0);
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) { } // unimplemented
}
