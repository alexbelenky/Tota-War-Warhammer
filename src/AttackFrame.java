import javax.swing.*;

public class AttackFrame {
    private AttackPanel panel;

    public AttackFrame(Army first, Army second) {
        JFrame frame = new JFrame("Attack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null); // auto-centers frame in screen
        frame.setUndecorated(true);
        panel = new AttackPanel(frame, first, second);
        frame.add(panel);
        frame.setVisible(true);
    }
}
