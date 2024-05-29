import javax.swing.*;

public class SettingsFrame {
    private SettingsPanel panel;

    public SettingsFrame() {
        JFrame frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        panel = new SettingsPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
