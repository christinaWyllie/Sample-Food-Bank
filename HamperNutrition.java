package edu.ucalgary.ensf409;
import java.util.*;

public class HamperNutrition {
  private LinkedList<Food> hamper = new LinkedList<Food>();
  private Inventory inventory;
  private Nutrition nutrition;	//This is total nutrition from family
  private LinkedList<Food> food;
  
  public HamperNutrition(Nutrition nutrition, Inventory inventory)	//Constructor
  {
	this.nutrition = nutrition;
	this.inventory = inventory;
	this.food = this.inventory.getInventory();
  } 
  
  public int[] calculateContent()	//Of Hamper
  {
    	int grain = 0;
   	int protein = 0;
    	int fAndV = 0;
    	int other = 0;
    	int calories = 0;
    
    	Iterator<Food> it = hamper.iterator();
    
    	while (it.hasNext())
    	{
      		Nutrition food = it.next().getNutritionalValue();
      		grain += food.getGrain();
      		protein += food.getProtein();
      		fAndV += food.getFV();
      		other += food.getOther();
      		calories += food.getCalories();
    	}
    
    	int[] contents = new int[5];
   	contents[0] = nutrition.getGrain() - grain;
    	contents[1] = nutrition.getProtein() - protein;
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
    	int[] content = calculateContent();
	
	if(content[0] > 0 || content[1] > 0 || content[2] > 0 || content[3] > 0 || content[4] > 0)
		throw new NotEnoughInventoryException();
	
	return;
  } 
  
  public void createBestHamper()
  {
	//LinkedList<Food> food = inventory.getInventory();
	int[] content = calculateContent();
	Food nothing = new Food(0, "nothing", 0, 0, 0, 0, 0);
	Food best = nothing;
	int b = 0;
	
	while(content[0] > 0 || content[1] > 0 || content[2] > 0 || content[3] > 0)	//0 - Grains, 1 - Protien, 2 - Fruits and Veg, 3 - Other
	{										//4 - Calories - not needed becuase if other categories are satisfied calories should be satisfied	
		Iterator<Food> it = food.iterator();
		while(it.hasNext())
		{
			Food f = it.next();
			if(f.getNutritionalValue().getGrain() >= b && f.getNutritionalValue().getGrain() <= content[0])
			{
				b = f.getNutritionalValue().getGrain();
				best =  f;
			}
			if(f.getNutritionalValue().getProtein() >= b && f.getNutritionalValue().getProtein() <= content[1])
			{
				b = f.getNutritionalValue().getProtein();
				best =  f;
			}
			if(f.getNutritionalValue().getFV() >= b && f.getNutritionalValue().getFV() <= content[2])
			{
				b = f.getNutritionalValue().getFV();
				best =  f;
			}
			if(f.getNutritionalValue().getOther() >= b && f.getNutritionalValue().getOther() <= content[3])
			{
				b = f.getNutritionalValue().getOther();
				best =  f;
			}
		}
		
		if(best == nothing)
			break;
		
		food.remove(best);	//Each food has unique item ID - so food will only be removed once
		hamper.add(best);
		content = calculateContent();
		b = 0;
		best = nothing;
	}
	
	content = calculateContent();  
	if(content[0] <= 0 && content[1] <= 0 && content[2] <= 0 && content[3] <= 0)
		return;
	
	Iterator<Food> it = food.iterator();
	b = 100000000;
	Food bestGrain = nothing;
	Food bestProtein = nothing;
	Food bestFV = nothing;
	Food bestOther = nothing;
	  
	while(it.hasNext())
	{
		//Find the smallest food that still exceeds the nutrients required
		Food f = it.next();
	
		if(content[0] > 0)
		{	
			if(f.getNutritionalValue().getGrain() < b && f.getNutritionalValue().getGrain() >= content[0])
			{
				b = f.getNutritionalValue().getGrain();
				bestGrain =  f;
			}
		}
		
		if(content[1] > 0)
		{
			if(f.getNutritionalValue().getProtein() < b && f.getNutritionalValue().getProtein() >= content[1])
			{
				b = f.getNutritionalValue().getProtein();
				bestProtein =  f;
			}
		}
		
		if(content[2] > 0)
		{
			if(f.getNutritionalValue().getFV() < b && f.getNutritionalValue().getFV() >= content[2])
			{
				b = f.getNutritionalValue().getFV();
				bestFV =  f;
			}
		}
		
		if(content[3] > 0)
		{
			if(f.getNutritionalValue().getOther() < b && f.getNutritionalValue().getOther() >= content[3])
			{
				b = f.getNutritionalValue().getOther();
				bestOther =  f;
			}
		}
	}
	
	if(bestGrain != nothing)
	{
		hamper.add(bestGrain);
		food.remove(bestGrain);
	}
	if(bestProtein != nothing)
	{
		hamper.add(bestProtein);
		food.remove(bestProtein);
	}
	if(bestFV != nothing)
	{
		hamper.add(bestFV);
		food.remove(bestFV);
	}
	if(bestOther != nothing)
	{
		hamper.add(bestOther);
		food.remove(bestOther);
	}
	
	try 
	{
		checkInventory();
		removeExtraFromHamper();
		//removeFromInventory();	//Will this be called in orderform?
	}
	
	catch (NotEnoughInventoryException e) 
	{
		e.printStackTrace();
		System.exit(1);
	}
  }
  
 private void removeExtraFromHamper()
  {
	LinkedList<Food> betterHamper = copyHamper();
	Iterator<Food> it = betterHamper.iterator();

	while(it.hasNext())
	{
		Food f = it.next();
		hamper.remove(f);
		int[] content = calculateContent();
		if(content[0] > 0 || content[1] > 0 || content[2] > 0 || content[3] > 0)
			hamper.add(f);
		else 
			food.add(f);
	}
  }
  
  public LinkedList<Food> copyHamper()	//Creates deep copy of hamper
  {
	Iterator<Food> it = hamper.iterator();
	LinkedList<Food> hamperCopy = new LinkedList<Food>();
		
	while(it.hasNext())
	{
		hamperCopy.add(it.next());
	}
		
	return hamperCopy;
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
