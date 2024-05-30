import javax.swing.*;

public class SettlementFrame {
    private SettlementPanel panel;

    public SettlementFrame(boolean isUsers, Settlement settlement) {
        JFrame frame = new JFrame("Settlement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 480);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        if (isUsers) {
            panel = new UserSettlementPanel(frame, settlement);
        } else {
            panel = new OtherSettlementPanel(frame, settlement);
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}
