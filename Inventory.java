//Inventory

public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removedInventory;
  private static int[][] calorieTable; 
  
  public Inventory(){
    this.dataAccess = new DataBase();
    this.inventory = this.dataAccess.getInventoryInfo();
    this.calorieTable = this.dataAccess.getCalorieInfo();
  }
   //needs more methods 
}
