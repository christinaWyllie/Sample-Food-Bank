//Inventory
import java.util.*;

public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removeInventory = new LinkedList<Food>();
  private static int[][] calorieTable; 
  
  public Inventory(){
    this.dataAccess = new DataBase();
    setInventory(this.dataAccess.getInventoryInfo());
    setCalorieTable(this.dataAccess.getCalorieInfo());
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
    for (int k = 0; k < this.removeInventory.size(); k++)
    {
		  int tbr = removeInventory.get(k).getFoodID();
		
		  for (int p = 0; p < this.inventory.size(); p++)
		  {
			  if (this.inventory.get(p).getFoodID() == tbr)
			  {
				  inventory.remove(p);
			  }
		  }
	  }
  }
  
  public boolean removeDataBase(){ //only function not tested yet bc no database
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
