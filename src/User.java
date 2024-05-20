import java.util.ArrayList;

public class User {
    private final String name;
    private ArrayList<Army> armies;
    private ArrayList<Province> provinces;

    public User(String name) {
        this.name = name;
        armies = new ArrayList<>();
        provinces = new ArrayList<>();
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

    public void addProvince(Province province) {
        provinces.add(province);
    }

    public void removeArmy(Army army) {
        armies.remove(army);
    }

    public void removeProvince(Province province) {
        provinces.remove(province);
    }
}
