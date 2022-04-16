/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: FormatOutput.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.2
@since 1.0
 */

package edu.ucalgary.ensf409;
import java.util.*;

/**
 * This class uses the caloric information determined for the entire
 * family and the available inventory in the database to create a hamper
 * of food items that best meets the needs of the family with the least 
 * overage in terms of calories per category.
 */
public class HamperNutrition {
  private LinkedList<Food> hamper = new LinkedList<Food>();
  private Inventory inventory;
  private Nutrition nutrition;	//This is total nutrition from family
  private LinkedList<Food> food;
  
  /**
   * Sole class constructor that initializes the nutrition information 
   * and inventory for use in calculation of the hamper.
   */
  public HamperNutrition(Nutrition nutrition, Inventory inventory)	//Constructor
  {
	this.nutrition = nutrition;
	this.inventory = inventory;
	this.food = updateInventory();
  } 
  
  /**
   * This method makes sure that the most updated version of the
   * inventory linked list from the inventory class is used in further calculation
   * of hampers, so that only items that have not yet been placed in a hamper 
   * are used in calculation of future hampers.
   * 
   * @return 	returns a linked list of food that has not yet been used in a hamper
   */
  private LinkedList<Food> updateInventory()
  {
		LinkedList<Food> remove = inventory.getRemoveInventory();
		LinkedList<Food> inv = inventory.getInventory();
		
		if(remove.size() == 0)
			return inv;
		
		else 
		{
			Iterator<Food> it = remove.iterator();
			while(it.hasNext())
			{
				inv.remove(it.next());
			}
		}
		
		return inv;
  }

/**
 * This method returns the amount of calories that have been fullfilled by
 * the hamper order, seperated by category. Negative values mean that the minimum
 * number of calories in that category have been fullfilled.
 * 
 * @return 	returns an integer array of the caloric content that has been fullfilled so far per category
 */
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
  
  /**
   * This method adds a food item to the hamper being created.
   * 
   * @param food 	a food object that needs to be added to the hamper being created
   */
  public void addToHamper(Food food)
  {
    	hamper.add(food);
	this.food.remove(food);
	inventory.addRemoveInventory(hamper);
	  
  }
  
  /**
   * This method returns the hamper that has been created according to 
   * the given input caloric needs.
   * 
   * @return 	returns a linked list of food items that is the hamper for the order
   */
  public LinkedList<Food> getHamper()
  {
    	return this.hamper;
  }
  
  /**
   * This method checks that all minimum caloric amounts per category
   * have been met, after the best hamper is created. If any category 
   * was not able to be fullfilled, then an exception is thrown.
   * 
   * @throws NotEnoughInventoryException	throws if the order cannot meet all caloric needs
   */
  public void checkInventory() throws NotEnoughInventoryException
  {
		int[] content = calculateContent();
	
		if(content[0] > 0)
			throw new NotEnoughInventoryException("grains");
		else if(content[1] > 0)
			throw new NotEnoughInventoryException("proteins");
		else if(content[2] > 0)
			throw new NotEnoughInventoryException("fruits and vegetables");
		else if(content[3] > 0)
			throw new NotEnoughInventoryException("others");
		return;
  } 
  
  /**
   * This method creates the best possible hamper for the given caloric needs
   * that hits the minimum needs per category, while reducing overage by iterating
   * through the available inventory to select the best possible combination to 
   * put in the hamper.
   */
  public void createBestHamper() throws NotEnoughInventoryException
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
	
	checkInventory();
	removeExtraFromHamper();
	inventory.addRemoveInventory(hamper);
	
  }
  
  /**
   * This method iterates through the best hamper that has been created, and 
   * for each item in the hamper, tries to determine the caloric content per 
   * category if the item is removed. If the hamper can still meet all needs
   * when the item is removed, the item is then taken out of the hamper.
   */
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
  /**
   * This method creates a new linked list of food objects that is a deep 
   * copy of the created hamper. 
   * 
   * @return  returns a linked list of food objects that is a deep copy of the hamper
   */
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

 /**
  * This method calls the remove method from the inventory object to 
  * update the inventory list in the inventory class to reflect the available
  * inventory that is left after the creation of a hamper.
  */
  public void removeFromInventory()
  {
	inventory.removeInventory();
  }

/**
 * This method returns the inventory object stored within the HamperNutrition
 * class.
 * 
 * @return 	returns an inventory object that is used in creation of the hamper
 */
  public Inventory getInventory()
  {
	return this.inventory;
  }
  
 /**
 * This method sets the inventory object stored within the HamperNutrition
 * class.
 * 
 * @param i 	Inventory object that is used in creation of the hamper
 */
  public void setInventory(Inventory i)
  {
	this.inventory = i;
  }
  
/**
 * This method retruns the food likned list stored within the HamperNutrition
 * class.
 * 
 * @return 	retruns a linked list of food objects that represenst the inventory
 */
  public LinkedList<Food> getFood()
  {
	  return this.food;
  }
	
}
