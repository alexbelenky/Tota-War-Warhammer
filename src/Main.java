public class Main {
    public static void main(String[] args) {
//        WelcomeFrame start = new WelcomeFrame();
        User user = new User("Karl");
        Army army = new Army("a", "b");
        user.addArmy(army);
        System.out.println(user.getArmies());
        user.removeArmy(army);
        System.out.println(user.getArmies());
    }
}
