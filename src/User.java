import java.util.ArrayList;

public class User {
    private final String name;
    private final ArrayList<Army> armies;

    public User(String name) {
        this.name = name;
        armies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Army> getArmies() {
        return armies;
    }

    public void addArmy(Army army) {
        armies.add(army);
    }

    public void removeArmy(Army army) {
        armies.remove(army);
    }
}
