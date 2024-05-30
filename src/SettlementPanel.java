import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SettlementPanel extends JPanel implements ActionListener {
    private BufferedImage background;
    private JButton leave;
    private JFrame enclosingFrame;
    private Province province;
    private Settlement selectedSettlement;

    public SettlementPanel(JFrame frame, Settlement settlement) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        leave = new JButton("X");
        add(leave);
        leave.addActionListener(this);
        enclosingFrame = frame;
        selectedSettlement = settlement;
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
            if (button == leave) {
                enclosingFrame.setVisible(false);
            }
        }
    }
}
