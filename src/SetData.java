//THIS CLASS IS STRICTLY TO HAVE A NAME FOR EVERYTHING THAT IS NOT SET BY THE USER

import java.util.ArrayList;
import java.util.Arrays;

public class SetData {
    //values can all be changed later
    private User user;
    private OtherLord enemy;
    private String name;
    private ArrayList<Province> allProvinces;
    private ArrayList<Province> userProvince;
    private ArrayList<Province> enemyProvince;
    private Army userArmy;
    private Army enemyArmy;
    public SetData(String name) {
        this.name = name;
        userProvince = new ArrayList<>();
        enemyProvince = new ArrayList<>();
        SetProvinces();
        SetArmies();
        user = new User(name, userArmy, userProvince);
        enemy = new OtherLord("Scary aa", enemyArmy, enemyProvince);
    }

    private void SetProvinces() {
        System.out.println(name);
        Settlement Altdorf = new Settlement(true, "Altdorf", 700, 680, true);
        Settlement Grunburg = new Settlement(false, "Grunburg", 600, 750, true);
        Settlement Eilhart = new Settlement(false, "Eilhart", 650, 820, true);
        Settlement Ubersreik = new Settlement(false, "Ubersreik", 730, 800, true);
        ArrayList<Settlement> ReiklandSettlements = new ArrayList<>(Arrays.asList(Altdorf, Grunburg, Eilhart, Ubersreik));
        Province Reikland = new Province(false, "Reikland", 4, ReiklandSettlements);

        Settlement Middenheim = new Settlement(true, "Middenheim", 750, 500, false);
        Settlement Middenstag = new Settlement(false, "Middenstag", 840, 360, false);
        Settlement Weismund = new Settlement(false, "Weismund", 540, 630, false);
        Settlement Carroburg = new Settlement(false, "Carroburg", 720, 390, false);
        ArrayList<Settlement> MiddenlandSettlements = new ArrayList<>(Arrays.asList(Middenheim, Middenstag, Weismund, Carroburg));
        Province Middenland = new Province(false, "Middenland", 4, MiddenlandSettlements);
        if (name.equals("Karl Franz")) {
            userProvince.add(Reikland);
        } else {
            //ikit's settlements
        }
        enemyProvince.add(Middenland);
    }

    private void SetArmies() {
        if (name.equals("Karl Franz")) {
            Army userArmy = new Army("The March", "Karl Franz", true, 660, 740);
            Unit peasent = new Unit("Peasent", false, 1000, 160, 50, 25, 10, 15, 0, 100);
            for (int i = 0; i < 10; i++) {
                userArmy.addUnit(peasent);
            }
            this.userArmy = userArmy;
        } else {
            //ikit
        }
        Army enemyArmy = new Army("Enemy army", "enemy", false, 500, 500);
        this.enemyArmy = enemyArmy;
    }

    public ArrayList<Province> getAllProvinces() {
        return allProvinces;
    }

    public User getUser() {
        return user;
    }

    public Army getEnemyArmy() {
        return enemyArmy;
    }

    public OtherLord getEnemy() {
        return enemy;
    }
}
