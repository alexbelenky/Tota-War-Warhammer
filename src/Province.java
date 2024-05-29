import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Province {
    private boolean isUnited;
    private final String name;
    private final int amountOfPossibleSettlements;
    private ArrayList<Settlement> settlements;
    private ArrayList<Settlement> userSettlements;

    public Province(boolean isUnited, String name, int amount, ArrayList<Settlement> userSettlements) {
        this.isUnited = isUnited;
        this.name = name;
        amountOfPossibleSettlements = amount;
        settlements = new ArrayList<>();
        this.userSettlements = userSettlements;
    }

    public boolean isUnitedUser() {
        return userSettlements.size() == amountOfPossibleSettlements;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfPossibleSettlements() {
        return amountOfPossibleSettlements;
    }

    public ArrayList<Settlement> getSettlements() {
        return settlements;
    }
    public ArrayList<Settlement> getUserSettlements() {
        return userSettlements;
    }

    public void addUserSettlement(Settlement settlement) {userSettlements.add(settlement); }

    public void setUnited(boolean united) {
        isUnited = united;
    }

    public void setSettlements(ArrayList<Settlement> settlements) {
        this.settlements = settlements;
    }

    public void changeSettlement(Settlement settlement) {
        //change the settlement ownership or level or name
    }
}
