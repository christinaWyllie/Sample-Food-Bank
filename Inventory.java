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
  //removes from inventory linkedlist and puts into removed invernotry linkedlist
  public void removeFromInventory(LinkedList<Food> toBeRemoved);
    
  //removes from database through dataAccess object
  public boolean removeDataBase();
   
}
