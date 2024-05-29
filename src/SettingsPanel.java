import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SettingsPanel extends JPanel implements ActionListener {
    private BufferedImage background;
    private JButton exit;
    private JButton something;
    private JFrame enclosingFrame;

    public SettingsPanel(JFrame frame) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        exit = new JButton("Exit");
        add(exit);
        exit.addActionListener(this);
        something = new JButton("Smth");
        add(something);
        something.addActionListener(this);
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
            if (button == something) {

            } else if (button == exit) {
                enclosingFrame.setVisible(false);
            }
        }
    }
}
