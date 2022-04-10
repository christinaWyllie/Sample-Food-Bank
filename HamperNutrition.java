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
    contents[0] = nutrition.getGrain() - grain;
    contents[1] = nutrition.getProtien() - protien;
    contents[2] = nutrition.getFV() - fAndV;
    contents[3] = nutrition.getOther() - other;
    contents[4] = nutrition.getCalories() - calories;
    
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
		LinkedList<Food> food = inventory.getInventory();
		Iterator<Food> it = food.iterator();
		Food first = new Food(0, 0, 0, 0, 0, 0, "nothing");
		
		Food bestGrain = first;
		Food bestProtien = first;
		Food bestFruitAndVeg = first;
		Food bestOther = first;
		
		while(it.hasNext())
		{
			Iterator<Food> iter = food.iterator();
			int[] con = calculateContents();
				
			while(iter.hasNext())
			{
					Food f = iter.next();
					if(f.getNutritionalValue().getGrain() > bestGrain.getNutritionalValue().getGrain())
						bestGrain =  f;
					if(f.getNutritionalValue().getProtien() > bestProtien.getNutritionalValue().getProtien())
						bestProtien =  f;
					if(f.getNutritionalValue().getFV() > bestFruitAndVeg.getNutritionalValue().getFV())
						bestFruitAndVeg =  f;
					if(f.getNutritionalValue().getOther() > bestOther.getNutritionalValue().getOther())
						bestOther =  f;
			}
			
			if(bestGrain.getNutritionalValue().getGrain() <= con[0])
			{
				hamper.add(bestGrain);
				food.remove(bestGrain);
				con = calculateContents();	//Won't work change
			}
			
			
			if(bestGrain != bestProtien && bestProtien.getNutritionalValue().getProtien() <= con[1])
				hamper.add(bestProtien);
			con = calculateContents();
			
			if
			
		}
		
		/*
		int i = 0;
		
    helpCreateBestHamper(i, food);
    
    ArrayList<ArrayList<Food>> = new ArrayList<ArrayList<Food>>();*/
    
  }
  
  private void helpCreateBestHamper(int i, LinkedList<Food> food)
  {
    int[] content = calculateContent(); 
		
    if(content[0] >= 0 && content[1] >= 0 && content[2] >= 0 && content[3] >= 0 && content[4] >= 0) //Add buffer
      return;
    else 
    {
      if(content[0] >= 0 || content[1] >= 0 || content[2] >= 0 || content[3] >= 0)
			{
				Iterator<Food> it = food.iterator();
				
			}
			
			hamper.add(food.get(i));
			i++;
      helpCreateBestHamper(i, food);
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
