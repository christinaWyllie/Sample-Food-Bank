/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestHamperNutrition.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.3
@since 1.0
 */
 
package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestHamperNutrition
{
	
	Inventory inventory;
	LinkedList<Food> food;

	@Test
	public void testCheckInventoryNotEnoughInventory() 	
	{
	//tests that the NotEnoughInventoryExcpetion was thrown when there has not enough/any inventory available
		helpCreateInventory();
		boolean correctException = false;
		
		try
		{	
			Nutrition n = new Nutrition(1200, 700, 1300, 200, 3400);
			HamperNutrition hamp = new HamperNutrition(n, inventory);
			hamp.setInventory(inventory);
			hamp.createBestHamper();	//Calls checkInventory()
			hamp.checkInventory();
		}
		
		catch(NotEnoughInventoryException e)
		{
			correctException = true;
		}
		assertTrue("NotEnoughInventory excpetion was not thrown when there is not enough inventory to create a hamper.", correctException);
	}
	
	@Test 
	public void testHamperNutritionConstructor() 
	{      
		helpCreateInventory();
		Nutrition n = new Nutrition(120, 140, 70, 130, 460);
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		
		assertNotNull("HamperNutrition constructor did not create an object when given a nutrition object:", hamp);
		//Initialize hamper linked list in constructor and should be not null;
		assertNotNull("Hamper LinkedList was null:", hamp.getHamper());
	}
			   
	@Test
	public void testHamperGetterAndSetters()
	{
		//Tests getHamper, addToHamper with one food item
		helpCreateInventory();
		LinkedList<Food> expectedHamper = new LinkedList<Food>();
		Food food1 = new Food(1, "Broccoli", 0, 100, 0, 0, 87);
		expectedHamper.add(food1);
			
		Nutrition n = new Nutrition(120, 140, 70, 130, 460);
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		hamp.addToHamper(food1);
		LinkedList<Food> hamper = hamp.getHamper();
		Iterator<Food> it = hamper.iterator();
		Iterator<Food> iter = expectedHamper.iterator();
		
		assertEquals("Method getHamper did not return the expected hamper. Hamper is not the expected size:", expectedHamper.size(), hamper.size());
		while(it.hasNext() && iter.hasNext())
		{
			assertEquals("Method getHamper did not return the expected hamper:", iter.next().getName(), it.next().getName());
		}
		
	}

	@Test
	public void testCreateBestHamperChoosesBestExactItem()
	{
	//Test createBestHamper(), getHamper()
		helpCreateInventory();
		Food food4 = new Food(4, "Spaghetti", 20, 30, 40, 10, 90);
		LinkedList<Food> expectedBestHamper = new LinkedList<Food>();
		expectedBestHamper.add(food4);
		
		Nutrition n = new Nutrition(18, 27, 36, 9, 90);	//Matches spaghetti exactly, should choose spaghetti
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		hamp.createBestHamper();
		
		LinkedList<Food> hamper = hamp.getHamper();
		
		Iterator<Food> it = hamper.iterator();
		Iterator<Food> iter = expectedBestHamper.iterator();
		assertEquals("Method createBestHamper did not create the best hamper. Hamper is not the expected size:", expectedBestHamper.size(), hamper.size());
		while(it.hasNext() && iter.hasNext())
		{
			assertEquals("Method getHamper did not return the expected hamper:", iter.next().getName(), it.next().getName());
		}
	}
			   
	@Test
	public void testCreateBestHamperChoosesBestApproxItem()
	{
	//Test createBestHamper(), getHamper()
		helpCreateInventory();
		Food food4 = new Food(4, "Spaghetti", 20, 30, 40, 10, 90);
		LinkedList<Food> expectedBestHamper = new LinkedList<Food>();
		expectedBestHamper.add(food4);
		
		Nutrition n = new Nutrition(15, 25, 35, 9, 84);	//Best match for caloric intake is spaghetti, should choose spaghetti
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		hamp.createBestHamper();
		
		LinkedList<Food> hamper = hamp.getHamper();
		Iterator<Food> it = hamper.iterator();
		Iterator<Food> iter = expectedBestHamper.iterator();
		
		assertEquals("Method createBestHamper did not create the best hamper. Hamper is not the expected size:", expectedBestHamper.size(), hamper.size());
		while(it.hasNext() && iter.hasNext())
		{
			assertEquals("Method getHamper did not return the expected hamper:", iter.next().getName(), it.next().getName());
		}
	}
	
	@Test
	public void testInventoryRemoved()
	{
		//Test removeInventory() which removes all food objects 
		//in hamper LinkedList from Food Linked List in Inventory class  
		
		helpCreateInventory();
		Food food4 = new Food(4, "Spaghetti", 20, 30, 40, 10, 90);
		food.remove(food4);
		
		Nutrition n = new Nutrition(15, 25, 45, 15, 60);	//Should create a hamper with broccoli and remove broccoli from inventory linked list
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		hamp.createBestHamper();
		hamp.removeFromInventory();
		LinkedList<Food> foundInventory = hamp.getInventory().getInventory();
		
		assertEquals("Method getInventory did not return the expected Inventory:", food, foundInventory);
	
	}
	
	@Test
	public void testCalcualteContent()
	{
		helpCreateInventory();
		Food food1 = new Food(1, "Broccoli", 0, 100, 0, 0, 87);
		Food food2 = new Food(2, "Chocolate", 0, 0, 0, 100, 700);
		Nutrition n = new Nutrition(120, 140, 70, 130, 460);
		HamperNutrition hamp = new HamperNutrition(n, inventory);
		hamp.addToHamper(food1);
		hamp.addToHamper(food2);
		
		int[] expectedContent = {120, 70, 53, -570, -327};
		int[] foundContent = hamp.calculateContent();
		
		assertEquals("Method calculateContent() did not return the expected content:", Arrays.toString(expectedContent), Arrays.toString(foundContent));
	}
	
	/**********************************HELPER ********************************************/
	public void helpCreateInventory()
	{
		Food food1 = new Food(1, "Broccoli", 0, 100, 0, 0, 87);
		Food food2 = new Food(2, "Chocolate", 0, 0, 0, 100, 700);
		Food food3 = new Food(3, "Masala", 0, 0, 87, 13, 100);
		Food food4 = new Food(4, "Spaghetti", 20, 30, 40, 10, 90);
		
		LinkedList<Food> f = new LinkedList<Food>();
		f.add(food1);
		f.add(food2);
		f.add(food3);
		f.add(food4);
		
		this.food = f;
		
		this.inventory = new Inventory();
		inventory.setInventory(food);
	}
}
