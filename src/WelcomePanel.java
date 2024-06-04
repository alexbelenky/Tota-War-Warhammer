import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//this will be changed to how the game looks like when you first start it
public class WelcomePanel extends JPanel implements MouseListener, ActionListener {
    private BufferedImage background;
    private Button battleButton;
    private Button campaignButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button quitButton;
    private JButton quit;
    private JButton settings;
    private JButton campaign;
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
        enclosingFrame = frame;
        setLayout(new FlowLayout());
        quit = new JButton("Quit");
        add(quit);
        quit.addActionListener(this);
        settings = new JButton("Settings");
        add(settings);
        settings.addActionListener(this);
        campaign = new JButton("Campaign");
        add(campaign);
        campaign.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(battleButton.getImage(), (int) battleButton.getxCoord(), (int) battleButton.getyCoord(), null);
        g.drawImage(campaignButton.getImage(), (int) campaignButton.getxCoord(), (int) campaignButton.getyCoord(), null);
        g.drawImage(multiplayerButton.getImage(), (int) multiplayerButton.getxCoord(), (int) multiplayerButton.getyCoord(), null);
        g.drawImage(optionsButton.getImage(), (int) optionsButton.getxCoord(), (int) optionsButton.getyCoord(), null);
        g.drawImage(quitButton.getImage(), (int) quitButton.getxCoord(), (int) quitButton.getyCoord(), null);

    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == campaign) {
//                PickCharacterFrame f = new PickCharacterFrame();
//                enclosingFrame.setVisible(false);
            } else if (button == settings) {
                SettingsFrame f = new SettingsFrame();
            } else if (button == quit) {
                System.exit(0);
            }
        }
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click

        } else {

        }
    }

    public void mouseEntered(MouseEvent e) {
        if (battleButton.buttonRect().contains(e.getPoint())) {
            System.out.println("Ivanov is a pussy ");
        }System.out.println("Ivanov is a pussy ");

    }

    public void mouseExited(MouseEvent e) { } // unimplemented
}
