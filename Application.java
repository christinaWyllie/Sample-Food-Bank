
package edu.ucalgary.ensf409;

public class Application{
  
  private int numHamper = 1;
  private Iventory inventory;
  private ArrayList<Family> families;
  private ArrayList<HamperNutrition> hamper;
  
  public Application(int[] var){
    this.inventory = new Inventory();
    int[][] calorieTable = inventory.getCalorieTable();
    this.families = new ArrayList<Family>();
    this.families.add(new Family(var, calorieTable));
    this.hamper = new ArrayList<HamperNutrition>();
    this.hamper.add(new HamperNutrition(this.families.get(numHampers-1).getTotal())); //What nutriton object do I send in?
  }
 
  public void addHamper(int[] var) {
     this.numHampers++;
     this.families.add(new Family(var, this.inventory.calorieTable()));
     this.hamper.add(new HamperNutrition(this.families.get(numHampers-1).getTotal())); //Still dont know what nutriton object im sending 
  }
  
  public int[] getUserInput(int index) {return this.families.get(index).getFamilyMembers();};
  public int getNumHamper() {return this.numHamper;};
  public ArrayList<Family> getFamiles() {return this.familes;};
  public Arraylist<HamperNutrition> getHampers() {return this.hamper;};
  public Family getFamily(int index) {return this.familes.get(index);};
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();};
  public Inventory getInventory() {return this.inventory;};
}
