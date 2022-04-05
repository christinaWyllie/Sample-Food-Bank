//Inventory

public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removeInventory;
  private static int[][] calorieTable; 
  
  public Inventory(){
    this.dataAccess = new DataBase();
    this.inventory = setInventory(this.dataAccess.getInventoryInfo());
    this.calorieTable = this.dataAccess.getCalorieInfo();
  }
  
  public void setInventory(LinkedList<Food> i){
    this.inventory = i;
  }
  
  public LinkedList<Food> getInventory(){
    return this.inventory;
  }
  
  public LinkedList<Food> getRemoveInventory(){
    return this.removeInventory;
  }
  
  public void setRemoveInventory(LinkedList<Food> r)
  { 
    for (int k = 0; k < r.size(); k++)
    {
      this.removeInventory.add(r.get(k));
    }
  }
  
  public void removeInventory(){
    for (int k = 0; k < this.removeInventory.size(); k++){
      Food toBeRemoved = this.removeInventory.get(k);
      this.inventory.remove(toBeRemoved);
    }
  }
  
  public boolean removeDataBase(){
    boolean success = this.dataAccess.updateDataBase(this.removeInventory);
    if (success == true)
    {
      this.removeInventory.clear();
    }
    return success;
  }
  
  public int[][] getCalorieTable(){
    return this.calorieTable;
  }
  
  public void setCalorieTable(int[][] s)
  {
    this.calorieTable = s;
  }
}
