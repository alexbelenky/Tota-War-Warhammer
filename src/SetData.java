//THIS CLASS IS STRICTLY TO HAVE A NAME FOR EVERYTHING THAT IS NOT SET BY THE USER

import java.util.ArrayList;
import java.util.Arrays;

public class SetData {
    //values can all be changed later
    private User user;
    private String name;
    private ArrayList<Province> allProvinces;
    private ArrayList<Province> userProvince;
    private Army userArmy;

    public SetData(String name) {
        this.name = name;
        userProvince = new ArrayList<>();
        SetProvinces();
        SetArmies();
        user = new User(name, userArmy, userProvince);
    }

    private void SetProvinces() {
        System.out.println(name);
        Settlement Altdorf = new Settlement(true, "Altdorf", 700, 680); //can make it so that the starting faction is already put
        Settlement Grunburg = new Settlement(false, "Grunburg", 600, 750);
        Settlement Eilhart = new Settlement(false, "Eilhart", 650, 820);
        Settlement Ubersreik = new Settlement(false, "Ubersreik", 730, 800);
        ArrayList<Settlement> ReiklandSettlements = new ArrayList<>(Arrays.asList(Altdorf, Grunburg, Eilhart, Ubersreik));
        Province Reikland = new Province(false, "Reikland", 4, ReiklandSettlements);
        //more Settlements here
        if (name.equals("Karl Franz")) {
            userProvince.add(Reikland);
        } else {
            //ikit's settlements
        }
    }

    private void SetArmies() {
        if (name.equals("Karl Franz")) {
            Army army = new Army("Check later", "later", true, 100, 100); //xCord and yCord are temp
            userArmy = army;
        } else {
            //ikit
        }
    }

    public ArrayList<Province> getAllProvinces() {
        return allProvinces;
    }

    public User getUser() {
        return user;
    }
}
