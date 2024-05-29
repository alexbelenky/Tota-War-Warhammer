import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class Army {
    private ArrayList<Unit> units;
    private BufferedImage armyImage;
    private String name;
    private String general;
    private double xCoord;
    private double yCoord;

    public Army(String name, String general) {
        this.name = name;
        this.general = general;
        units = new ArrayList<>();
        xCoord = 100;
        yCoord = 100;
        try {
            armyImage = ImageIO.read(new File(("src/GUI/Armies/tempLordArmy.PNG")));
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

    public int compareTo(Army army) { //returns 1 if this army is greater, -1 if not, and 0 if equal
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
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

}
