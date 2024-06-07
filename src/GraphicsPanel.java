import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener {
    private BufferedImage background;
    private Button quit;
    private Button diplomacy;
    private Button settings;
    private Button nextTurn;
    private ArrayList<Button> buttons;
    private User user;
    private ArrayList<OtherLord> enemies; //doesn't actually mean enemies, just other lords, probably will change
    private Diplomacy personalDiplomacy;
    private int turn;
    private Army selectedArmy;
    private Settlement selectedSettlement;

    public GraphicsPanel(String name) {
        try {
            background = ImageIO.read(new File("src/GUI/Background/tempBackground.PNG")); //will be something else
            quit = new Button("src/GUI/Buttons/exitButton.png", 2, 1020);
            diplomacy = new Button("temp", 5, 100); //need to change
            settings = new Button("temp", 5, 100); //need to change
            nextTurn = new Button("temp", 5, 100); //need to change
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addMouseListener(this);
        addMouseMotionListener(this);
        SetData data = new SetData(name);
        user = data.getUser();
        personalDiplomacy = new Diplomacy(user);
        enemies = new ArrayList<>(); //set later

        buttons = new ArrayList<>(Arrays.asList(quit, diplomacy, settings, nextTurn));
        for (Button button : buttons) {
            button.addMouseListener(button);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 100, 200, null);
        for (Button button : buttons) {
            if (button.isCustomVisible()) {
                g.drawImage(button.getImage(), (int) button.getxCoord(), (int) button.getyCoord(), null);
            }
        }

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

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    // ----- ActionListener interface methods -----
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() instanceof JButton) {
//            JButton button = (JButton) e.getSource();
//            if (button == diplomacy) {
//                DiplomacyFrame f = new DiplomacyFrame(personalDiplomacy);
//            } else if (button == settings) {
//                SettingsFrame f = new SettingsFrame();
//            } else if (button == nextTurn) {
//                turn++;
//            } else if (button == quit) {
//                System.exit(0);
//            }
//        }
//    }
}