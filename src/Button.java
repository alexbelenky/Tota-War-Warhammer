import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Button implements MouseListener {
    private BufferedImage image;
    private double xCoord;
    private double yCoord;
    private boolean isVisible;

    public Button(String string, double xCoord, double yCoord, boolean isVisible) {
        try {
            image = ImageIO.read(new File(string));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.isVisible = false;
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
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }



    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("hello");
    }

    public void mouseExited(MouseEvent e) {

    }
}
