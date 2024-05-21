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

    public int getPower() {
        int power = 0;
        for (Unit unit : units) {
            power += unit.getHealth() + unit.getMeleeAttack() + unit.getMeleeDefense() + unit.getAmmo() + unit.getChargeBonus() + unit.getLeadership() + unit.getFatigue();
        }
        return power;
    }

    public int compareTo(Army army) { //returns 1 if this army is greater, -1 if not, and 0 if equal
        if (getPower() > army.getPower()) {
            return 1;
        } else if (getPower() < army.getPower()) {
            return -1;
        }
        return 0;
    }
}
