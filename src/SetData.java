//THIS CLASS IS STRICTLY TO HAVE A NAME FOR EVERYTHING THAT IS NOT SET BY THE USER

import java.util.ArrayList;
import java.util.Arrays;

public class SetData {
    //values can all be changed later
    private ArrayList<Province> allProvinces;

    public SetData() {

    }

    private void SetProvinces() {
        Settlement Altdorf = new Settlement(true, "Altdorf");
        Settlement Grunburg = new Settlement(false, "Grunburg");
        Settlement Eilhart = new Settlement(false, "Eilhart");
        Settlement Ubersreik = new Settlement(false, "Ubersreik");
        ArrayList<Settlement> ReiklandSettlements = new ArrayList<>(Arrays.asList(Altdorf, Grunburg, Eilhart, Ubersreik));
        Province Reikland = new Province(false, "Reikland", 4, ReiklandSettlements);
    }

    public ArrayList<Province> getAllProvinces() {
        return allProvinces;
    }
}
