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
    private ArrayList<Building> buildings;
    private double xCoord;
    private double yCoord;
    private boolean isSelected;

    public Settlement(boolean isMajor, String name, double xCoord, double yCoord) {
        this.isMajor = isMajor;
        this.name = name;
        level = 1;
        buildings = new ArrayList<>();
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        isSelected = false;
        try {
            if (isMajor) {
                image = ImageIO.read(new File("src/GUI/Settlements/provinceSettlement.png"));
            } else {
                image = ImageIO.read(new File("src/GUI/Settlements/smallSettlementKarl.png"));
            }
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

    public ArrayList<Building> getBuildings() {
        return buildings;
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

    public void addBuilding(Building building) {
        buildings.add(building);
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
