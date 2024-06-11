import javax.swing.*;

public class DiplomacyEnemyFrame {
    private DiplomacyEnemyPanel panel;

    public DiplomacyEnemyFrame(Diplomacy diplomacy) {
        JFrame frame = new JFrame("DiplomacyEnemy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        frame.setUndecorated(true);
        panel = new DiplomacyEnemyPanel(frame, diplomacy);
        frame.add(panel);
        frame.setVisible(true);
    }
}
