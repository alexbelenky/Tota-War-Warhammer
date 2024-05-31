import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AttackPanel extends JPanel implements ActionListener {
    private BufferedImage background;
    private JButton exit;
    private JButton autoResolve;
    private JFrame enclosingFrame;
    private Army userArmy;
    private Army otherArmy;

    public AttackPanel(JFrame frame, Army userArmy, Army otherArmy) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        exit = new JButton("Exit");
        add(exit);
        exit.addActionListener(this);;
        autoResolve = new JButton("autoResolve");
        add(autoResolve);
        autoResolve.addActionListener(this);;
        this.userArmy = userArmy;
        this.otherArmy = otherArmy;
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
            if (button == autoResolve) {
                if (userArmy.compareTo(otherArmy) > 0) {
                    //win
                } else {
                    //lose
                }
            } else if (button == exit) {
                enclosingFrame.setVisible(false);
            }
        }
    }
}
