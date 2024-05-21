import java.util.ArrayList;

public class User {
    private final String name;
    private ArrayList<Army> armies;
    private ArrayList<Province> provinces;

    public User(String name, Army army, Province province) {
        this.name = name;
        armies = new ArrayList<>();
        addArmy(army);
        provinces = new ArrayList<>();
        addProvince(province);
    }

    public boolean attack(Army userArmy, Army enemyArmy) {
        if (userArmy.compareTo(enemyArmy) == 1) {
            return true;
        }
        return false;
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
