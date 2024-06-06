import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button extends JComponent implements MouseListener {
    private BufferedImage image;
    private double xCoord;
    private double yCoord;
    private boolean customVisible;

    public Button(String string, double xCoord, double yCoord) {
        try {
            image = ImageIO.read(new File(string));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.customVisible = false; // buttons not visible till hovered over
    }

    public BufferedImage getImage() {
        return image;
    }

    public double getxCoord() {
        return xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public Rectangle buttonRect() {
        int imageHeight = image.getHeight();
        int imageWidth = image.getWidth();
        return new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
    }

    public boolean isCustomVisible() {
        return customVisible;
    }

    public void setCustomVisible(boolean visible) {
        this.customVisible = visible;
    }

    // ----- MouseListener interface methods -----

    public void mouseClicked(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }
}