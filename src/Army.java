import java.util.ArrayList;

public class Army {
    private ArrayList<Unit> units;
    private String name;
    private String general;

    public Army(String name, String general) {
        this.name = name;
        this.general = general;
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }
}
