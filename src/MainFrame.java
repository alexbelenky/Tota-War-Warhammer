import javax.swing.*;

public class MainFrame implements Runnable {

    private GraphicsPanel panel;

    public MainFrame(String name) {
        JFrame frame = new JFrame("Total War Warhammer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);

        panel = new GraphicsPanel(name);
        frame.add(panel);
        frame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            panel.repaint();
        }
    }
}
