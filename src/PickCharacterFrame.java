import javax.swing.*;

public class PickCharacterFrame {
    private PickCharacterPanel panel;

    public PickCharacterFrame() {
        JFrame frame = new JFrame("Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        frame.setUndecorated(true);
        panel = new PickCharacterPanel(frame);
        frame.add(panel);
        frame.setVisible(true);
    }
}
