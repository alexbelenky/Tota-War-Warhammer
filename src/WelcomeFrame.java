import javax.swing.*;

public class WelcomeFrame {
    private WelcomePanel panel;

    public WelcomeFrame() {
        JFrame frame = new JFrame("Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        frame.setUndecorated(true);
        panel = new WelcomePanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
