import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DiplomacyPanel extends JPanel implements ActionListener {
    private BufferedImage background;
    private JButton exit;
    private JButton trade;
    private JFrame enclosingFrame;
    private Diplomacy diplomacy; //will pick otherLord in gui

    public DiplomacyPanel(JFrame frame, Diplomacy diplomacy) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        enclosingFrame = frame;
        exit = new JButton("Exit");
        add(exit);
        exit.addActionListener(this);
        trade = new JButton("Trade");
        add(trade);
        trade.addActionListener(this);
        this.diplomacy = diplomacy;
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
            if (button == trade) {
//                diplomacy.trade(new OtherLord("otherLord", new Army("a", "b", false, 100, 100), new Province(false, "land", 4, new ArrayList<Settlement>()))); //temp
            } else if (button == exit) {
                enclosingFrame.setVisible(false);
            }
        }
    }
}
