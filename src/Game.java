import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private User user;
    public Game() {
        System.out.println("Which faction"); //for gui
        pickUser("Karl Franz"); //picked in gui
    }

    private void pickUser(String name) {
        //check for specific characters
        Army army = new Army("empire", "get");
        ArrayList<Settlement> settlements = new ArrayList<>(Arrays.asList(new Settlement(true, "test"), new Settlement(false, "small")));
        Province province = new Province(false, "Reikland", 4, settlements);
        user = new User(name, army, province);
    }
}
