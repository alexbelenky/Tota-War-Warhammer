import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    private User user;
    private int turn;
    public Game() {
        System.out.println("Which faction"); //for gui
        pickUser("Karl Franz"); //picked in gui
        play();
    }

    private void play() {
        while(true) {
            //checks what the user does or picks
        }
    }
    private void pickUser(String name) {
        //check for specific characters (for example karl franz)
        Army army = new Army("empire", "get", true, 100, 100);
        ArrayList<Settlement> settlements = new ArrayList<>(Arrays.asList(new Settlement(true, "test", 100, 100), new Settlement(false, "small", 100, 100)));
        Province province = new Province(false, "Reikland", 4, settlements);
        user = new User(name, army, new ArrayList<Province>());
    }
}
