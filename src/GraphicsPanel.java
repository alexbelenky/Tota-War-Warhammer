import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private JButton quit;
    private JButton diplomacy;
    private JButton settings;
    private JButton nextTurn;
    //temp buttons (probably)
    private boolean[] pressedKeys;
    private User user;
    private ArrayList<OtherLord> enemies; //doesn't actually mean enemies, just other lords, probably will change
    private Diplomacy personalDiplomacy;
    private int turn;
    private Army selectedArmy;
    private Settlement selectedSettlement;

    public GraphicsPanel(String name) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        nextTurn = new JButton("next turn");
        add(nextTurn);
        nextTurn.addActionListener(this);
        quit = new JButton("Quit");
        add(quit);
        quit.addActionListener(this);
        settings = new JButton("Settings");
        add(settings);
        settings.addActionListener(this);
        diplomacy = new JButton("Diplomacy");
        add(diplomacy);
        diplomacy.addActionListener(this);
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        SetData data = new SetData(name);
        user = data.getUser();
        personalDiplomacy = new Diplomacy(user);
        enemies = new ArrayList<>(); //set later
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 100, 200, null);
        settings.setLocation(200, 400);
        quit.setLocation(300, 400);
        diplomacy.setLocation(100, 400);
        nextTurn.setLocation(500, 400);

        for(Army userArmy : user.getArmies()) {
            g.drawImage(userArmy.getArmyImage(), userArmy.getxCoord(), userArmy.getyCoord(), null);
        }

        for(Province province : user.getProvinces()) {
            for (Settlement settlement : province.getSettlements()) {
                g.drawImage(settlement.getImage(), settlement.getxCoord(), settlement.getyCoord(), null);
            }
        }

        for (OtherLord enemy : enemies) {
            for (Army enemyArmy : enemy.getArmies()) {
                g.drawImage(enemyArmy.getArmyImage(), enemyArmy.getxCoord(), enemyArmy.getyCoord(), null);
            }
        }
        // player moves left (A)
        if (pressedKeys[65]) {

        }

        // player moves right (D)
        if (pressedKeys[68]) {

        }

        // player moves up (W)
        if (pressedKeys[87]) {

        }

        // player moves down (S)
        if (pressedKeys[83]) {

        }
    }

    // ----- KeyListener interface methods -----
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            Point mouseClickLocation = e.getPoint();
            //ARMY CODE:
            for(Army userArmy : user.getArmies()) {
                if (userArmy.armyRect().contains(mouseClickLocation)) {
                    if (userArmy.isSelected()) {
                        userArmy.setSelected(false);
                        selectedArmy = null;
                        System.out.println("released");
                    } else {
                        selectedArmy = userArmy;
                        selectedArmy.setSelected(true);
                        System.out.println("clicked!");
                    }
                }
            }
            //ARMY END, SETTLEMENT CODE:
            for (Province userProvince : user.getProvinces()) {
                for (Settlement userSettlement : userProvince.getSettlements()) {
                    if (userSettlement.settlementRect().contains(mouseClickLocation)) {
                        if (userSettlement.isSelected()) {
                            userSettlement.setSelected(false);
                            selectedSettlement = null;
                            System.out.println("released");
                        } else {
                            selectedSettlement = userSettlement;
                            selectedSettlement.setSelected(true);
                            System.out.println("clicked!");
                            SettlementFrame f = new SettlementFrame(true, selectedSettlement);
                            selectedSettlement.setSelected(false);
                        }
                    }
                }
            }
        } else {
            Point mouseClickLocation = e.getPoint();
            //ARMY CODE:
            if (selectedArmy != null) {
                selectedArmy.move(mouseClickLocation);
                for(OtherLord otherLord : enemies) {
                    for(Army enemyArmy : otherLord.getArmies()) {
                        if (enemyArmy.armyRect().contains(mouseClickLocation)) {
                            AttackFrame f = new AttackFrame(selectedArmy, enemyArmy);
                        }
                    }
                }
            }
            //ARMY END
        }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) { } // unimplemented

    // ----- ActionListener interface methods -----
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == diplomacy) {
                DiplomacyFrame f = new DiplomacyFrame(personalDiplomacy);
            } else if (button == settings) {
                SettingsFrame f = new SettingsFrame();
            } else if (button == nextTurn) {
                turn++;
            } else if (button == quit) {
                System.exit(0);
            }
        }
    }
}