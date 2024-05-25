import java.util.ArrayList;


public class OtherLord {
   private final String name;
   private int treasury;
   private ArrayList<Army> armies;
   private ArrayList<Province> provinces;
   private int relations; //how much this faction likes the user


   public OtherLord(String name, Army army, Province province) {
       this.name = name;
       treasury = 0; //default
       armies = new ArrayList<>();
       addArmy(army);
       provinces = new ArrayList<>();
       addProvince(province);
       relations = 0; //default
   }


   public String getName() {
       return name;
   }


   public ArrayList<Army> getArmies() {
       return armies;
   }


   public ArrayList<Province> getProvinces() {
       return provinces;
   }


   public int getRelations() {
       return relations;
   }


   public void setRelations(int relations) {
       this.relations = relations;
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
