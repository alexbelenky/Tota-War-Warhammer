import javax.swing.*;

public class DiplomacyFrame {
    private DiplomacyPanel panel;

    public DiplomacyFrame(Diplomacy diplomacy) {
        JFrame frame = new JFrame("Diplomacy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        panel = new DiplomacyPanel(frame, diplomacy);
        frame.add(panel);
        frame.setVisible(true);
    }
}
