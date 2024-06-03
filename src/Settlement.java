import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Settlement {
    private BufferedImage image;
    private boolean isMajor;
    private int level;
    private String name;
    private Army garrison;
    private ArrayList<Building> buildings;
    private Army wanderingArmy;
    private double xCoord;
    private double yCoord;
    private boolean isSelected;

    public Settlement(boolean isMajor, String name) {
        this.isMajor = isMajor;
        this.name = name;
        level = 1;
        garrison = new Army("garrison", "general", true);
        buildings = new ArrayList<>();
        wanderingArmy = null;
        xCoord = 200;
        yCoord = 500;
        isSelected = false;
        try {
            image = ImageIO.read(new File("src/GUI/Settlements/tempSettlement.PNG"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isMajor() {
        return isMajor;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Army getGarrison() {
        return garrison;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public Army getWanderingArmy() {
        return wanderingArmy;
    }

    public BufferedImage getImage() {
        return image;
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

    public void addLevel() {
        level++;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void setGarrison(Army army) {
        garrison = army;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public boolean setWanderingArmy(Army wanderingArmy) { //returns true if army can occupy settlement, returns false otherwise
        if (wanderingArmy != null) {
            this.wanderingArmy = wanderingArmy;
            return true;
        }
        return false;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Rectangle settlementRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
