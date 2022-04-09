package edu.ucalgary.ensf409;

public class HamperNutrition implements Calculate{
  private LinkedList<Food> hamper = new LinkedList<Food>();
  private Inventory inventory = new Inventory();
  private Nutrition nutrition;
  
  public HamperNutrition(Nutrition nutrition)
  {
    this.nutrition = nutrition;
  } 
  
  public int[] calculateContent()
  {
    int grain = 0;
    int protien = 0;
    int fAndV = 0;
    int other = 0;
    int calories = 0;
    
    Iterator<Food> it = hamper.iterator();
    
    while (it.hasNext())
    {
      Nutrition food = it.next().getNutritionalValue();
      grain += food.getGrain();
      protien += food.getProtien();
      fAndV += food.getFV();
      other += food.getOther();
      calories += food.getCalories();
    }
    
    int[] contents = new int[5];
    contents[0] = grain - nutrition.getGrain();
    contents[1] = protien - nutrition.getProtien();
    contents[2] = fAndV - nutrition.getFV();
    contents[3] = other - nutrition.getOther();
    contents[4] = calories - nutrition.getCalories();
    
    return contents;
    
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
    
  } 
  
  public void createBestHamper()
  {
    /*//Outside ArrayList is the number of possible hampers 
    //Inside ArrayList is the hamper with the food 
    */
    helpCreateBestHamper();
    
    ArrayList<ArrayList<Food>> = new ArrayList<ArrayList<Food>>();
    
  }
  
  private ArrayList<ArrayList<Food>> helpCreateBestHamper(LinkedList<Food> food)
  {
    int[] content = calculateContent(); 
    if(content[0] >= 0 && content[1] >= 0 && content[2] >= 0 && content[3] >= 0 && content[4] >= 0) //Add buffer
      return;
    else 
    {
      
      removeFromInventory(f); //remove whatever food goes into the hamper from the inventory linked list
      helpCreateBestHamper(inventory.getInventory());
    }
    
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
