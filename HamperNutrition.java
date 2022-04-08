package edu.ucalgary.ensf409;

public class HamperNutrition implements Calculate{
  private LinkedList<Food> hamper = new LinkedList<Food>();
  private Inventory inventory = new Inventory();
  private Nutrition nutrition;
  
  public HamperNutrition(Nutrition nutrition)
  {
    this.nutrition = nutrition;
  } 
  
  public void calculateContent()
  {
 
  }
  
  public void addToHamper(Food food)
  {
    hamper.add(food);
  }
  
  public LinkedList<Food> getHamper()
  {
    return this.hamper;
  }
  
  public void checkInventory() throws NotEnoughInventoryException
  {
    if(nutrition.getGrain() > )
      throw new NotEnoughInventoryException();
    if(nutrition.getProtien() > )
      throw new NotEnoughInventoryException();
    
  } 
  
  public void createBestHamper()
  {
    //Outside ArrayList is the number of possible hampers 
    //Inside ArrayList is the hamper with the food 
    ArrayList<ArrayList<Food>> = new ArrayList<ArrayList<Food>>();
    
    for()
    
  }
  
  public void removeFromInventory()
  {
     inventory.removeInventory();
  }

  public Inventory getInventory()
  {
    return this.inventory;
  }
  
  public void setInventory(Inventory i)
  {
    this.inventory = i;
  }
  
}
