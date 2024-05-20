import java.util.ArrayList;

public class Settlement {
    private boolean isMajor;
    private int level;
    private String name;
    private Army garrison;
    private ArrayList<Building> buildings;
    private Army wanderingArmy;

    public Settlement(boolean isMajor, String name) {
        this.isMajor = isMajor;
        this.name = name;
        level = 1;
        garrison = new Army("garrison", "general");
        buildings = new ArrayList<>();
        wanderingArmy = null;
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
}
