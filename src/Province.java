import java.util.ArrayList;

public class Province {
    private boolean isUnited;
    private final String name;
    private final int amountOfPossibleSettlements;
    private ArrayList<Settlement> settlements;

    public Province(boolean isUnited, String name, int amount) {
        this.isUnited = isUnited;
        this.name = name;
        amountOfPossibleSettlements = amount;
        settlements = new ArrayList<>();
    }

    public boolean isUnited() {
        return isUnited;
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
