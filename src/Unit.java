public class Unit {
    private String name;
    private boolean isRanged;
    private int health;
    private int unitSize;
    private int leadership;
    private int meleeAttack;
    private int meleeDefense;
    private int chargeBonus;
    private int ammo;
    private int fatigue; //probably put string instead

    public Unit(String name, boolean isRanged, int health, int unitSize, int leadership, int meleeAttack, int meleeDefense, int chargeBonus, int ammo, int fatigue) {
        this.name = name;
        this.isRanged = isRanged;
        this.health = health;
        this.unitSize = unitSize;
        this.leadership = leadership;
        this.meleeAttack = meleeAttack;
        this.meleeDefense = meleeDefense;
        this.chargeBonus = chargeBonus;
        if (isRanged) {
            this.ammo = ammo;
        } else {
            this.ammo = 0;
        }
        this.fatigue = fatigue;
    }

    public String getName() {
        return name;
    }
    public boolean isRanged() {return isRanged;}

    public int getHealth() {
        return health;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public int getLeadership() {
        return leadership;
    }

    public int getMeleeAttack() {
        return meleeAttack;
    }

    public int getMeleeDefense() {
        return meleeDefense;
    }

    public int getChargeBonus() {
        return chargeBonus;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setUnitSize(int unitSize) {
        this.unitSize = unitSize;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public void setMeleeAttack(int meleeAttack) {
        this.meleeAttack = meleeAttack;
    }

    public void setMeleeDefense(int meleeDefense) {
        this.meleeDefense = meleeDefense;
    }

    public void setChargeBonus(int chargeBonus) {
        this.chargeBonus = chargeBonus;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
}
