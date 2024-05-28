import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//this will be changed to how the game looks like when you first start it
public class WelcomePanel extends JPanel implements ActionListener {
    private BufferedImage background;
    private JButton campaign;
    private JFrame enclosingFrame;

    public WelcomePanel(JFrame frame) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        campaign = new JButton("Campaign");
        add(campaign);
        campaign.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == campaign) {
                PickCharacterFrame f = new PickCharacterFrame();
                enclosingFrame.setVisible(false);
            }
        }
    }
}
