package edu.ucalgary.ensf409;

public class HamperNutrition implements Calculate{
  private LinkedList<Food> hamper = new LinkedList<Food>();
  private Inventory inventory;
  private Nutrition nutrition;	//This is total nutrition from family
  
  public HamperNutrition(Nutrition nutrition, Inventory inventory)	//Constructor
  {
	this.nutrition = nutrition;
	this.inventory = inventory;
  } 
  
  public int[] calculateContent()	//Of Hamper
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
  
  public void checkInventory() throws NotEnoughInventoryException	//May not need this
  {
    
  } 
  
  public void createBestHamper()
  {
	LinkedList<Food> food = inventory.getInventory();
	int[] content = calculateContent();
	Food best = new Food(0, 0, 0, 0, 0, 0, "nothing");
	int b = 0;
	
	while(content[0] > 0 && content[1] > 0 && content[2] > 0 && content[3] > 0)	//0 - Grains, 1 - Protien, 2 - Fruits and Veg, 3 - Other
	{										//4 - Calories - not needed becuase if other categories are satisfied calories should be satisfied	
		Iterator<Food> it = food.iterator();
		while(it.hasNext())
		{
			Food f = it.next();
			if(f.getNutritionalValue().getGrain() > b && f.getNutritionalValue().getGrain() <= content[0])
			{
				b = f.getNutritionalValue().getGrain();
				best =  f;
			}
			if(f.getNutritionalValue().getProtien() > b && f.getNutritionalValue().getProtien() <= content[1])
			{
				b = f.getNutritionalValue().getProtien();
				best =  f;
			}
			if(f.getNutritionalValue().getFV() > b && f.getNutritionalValue().getFV() <= content[2])
			{
				b = f.getNutritionalValue().getFV();
				best =  f;
			}
			if(f.getNutritionalValue().getOther() > b && f.getNutritionalValue().getOther() <= content[3])
			{
				b = f.getNutritionalValue().getOther();
				best =  f;
			}
		}
		
		try
		{
			food.remove(best);	//Each food has unique item ID
			hamper.add(best);
			content = calculateContent();
			b = 0;
			best = new Food(0, 0, 0, 0, 0, 0, "nothing");
		}
		catch(Exception e)
		{
			break;		//Maybe call different method if break doesn't work - could throw NotEnoughInvetoryException
		}
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
