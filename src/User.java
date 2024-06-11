import java.util.ArrayList;


public class User {
    private final String NAME;
    private int treasury;
    private ArrayList<Army> armies;
    private ArrayList<Province> provinces;


    public User(String name, Army army, ArrayList<Province> province) {
        this.NAME = name;
        treasury = 0; //default
        armies = new ArrayList<>();
        addArmy(army);
        provinces = province;
    }


    public boolean attack(Army userArmy, Army enemyArmy) {
        if (userArmy.compareTo(enemyArmy) == 1) {
            return true;
        }
        return false;
    }


    public String getNAME() {
        return NAME;
    }


    public int getTreasury() {
        return treasury;
    }


    public ArrayList<Army> getArmies() {
        return armies;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }

    public void setTreasury(int treasury) {
        this.treasury = treasury;
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
