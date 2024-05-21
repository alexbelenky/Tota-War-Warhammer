public class Hero extends Unit{
    public Hero(String name, boolean isRanged, int health, int leadership, int meleeAttack, int meleeDefense, int chargeBonus, int ammo, int fatigue) {
        super(name, isRanged, health, 1, leadership, meleeAttack, meleeDefense, chargeBonus, ammo, fatigue);
    }
}
