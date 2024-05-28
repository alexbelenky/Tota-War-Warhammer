import java.util.ArrayList;


public class Diplomacy {
    private int userReliability; //steadfast: 4 trustworthy: 3 untrustworthy: 2 unreliable: 1
    private User user;
    private ArrayList<String> trade;
    private ArrayList militaryAccess;
    private ArrayList nonAggression;
    private ArrayList defensiveAllies;
    private ArrayList militaryAllies;
    private ArrayList vassals;
    private ArrayList war;
    public Diplomacy(User user) {
        this.user = user;
        userReliability = 4;
        //could auto set diplomacy depending on which faction
        trade = new ArrayList<>();
    }

    public void trade (OtherLord otherLord) {
        if (otherLord.getRelations() > 20) {
            trade.add(otherLord.getName());
            otherLord.setRelations(otherLord.getRelations() + 10);
        }
    }
    public void diplomate(OtherLord otherLord) {
        System.out.println("Trade? Non-aggression?"); //will get this from gui
        //if trade:
        if (otherLord.getRelations() > 20) {


        }
    }
}
