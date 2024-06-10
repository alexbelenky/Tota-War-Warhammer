import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Army extends JComponent {
    private final double MOVE_AMT = 1;
    private ArrayList<Unit> units;
    private BufferedImage armyImage;
    private String name;
    private String general;
    private double xCoord;
    private double yCoord;
    private boolean isSelected;

    public Army(String name, String general, boolean isUser, double xCoord, double yCoord) {
        this.name = name;
        this.general = general;
        units = new ArrayList<>();
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        isSelected = false;
        try {
            if (isUser) {
                armyImage = ImageIO.read(new File(("src/GUI/Armies/karlArmy.png")));
            } else {
                armyImage = ImageIO.read(new File(("src/GUI/Armies/ratEnemy.png")));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

    public int getPower() {
        int power = 0;
        for (Unit unit : units) {
            power += unit.getHealth() + unit.getMeleeAttack() + unit.getMeleeDefense() + unit.getAmmo() + unit.getChargeBonus() + unit.getLeadership() + unit.getFatigue();
        }
        return power;
    }

    public BufferedImage getArmyImage() {
        return armyImage;
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void move(Point mouseClick) {
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean reachedX = false;
                boolean reachedY = false;

                if (mouseClick.x > xCoord) {
                    xCoord = Math.min(xCoord + MOVE_AMT, mouseClick.x);
                } else if (mouseClick.x < xCoord) {
                    xCoord = Math.max(xCoord - MOVE_AMT, mouseClick.x);
                } else {
                    reachedX = true;
                }

                if (mouseClick.y > yCoord) {
                    yCoord = Math.min(yCoord + MOVE_AMT, mouseClick.y);
                } else if (mouseClick.y < yCoord) {
                    yCoord = Math.max(yCoord - MOVE_AMT, mouseClick.y);
                } else {
                    reachedY = true;
                }

                repaint();

                if (reachedX && reachedY) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public int compareTo(Army army) {
        if (getPower() > army.getPower()) {
            return 1;
        } else if (getPower() < army.getPower()) {
            return -1;
        }
        return 0;
    }

    public Rectangle armyRect() {
        int imageHeight = getArmyImage().getHeight();
        int imageWidth = getArmyImage().getWidth();
        return new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
    }
}