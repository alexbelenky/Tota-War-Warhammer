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
    private JButton submitButton;
    private JFrame enclosingFrame;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        submitButton = new JButton("Karl Franz");
        add(submitButton);
        submitButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Who would you like to play as?", 920, 30);
        submitButton.setLocation(1200, 500);
    }

    // ACTIONLISTENER INTERFACE METHODS
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                String playerName = "Karl Franz";
                MainFrame f = new MainFrame(playerName);
                enclosingFrame.setVisible(false);
            }
        }
    }
}
