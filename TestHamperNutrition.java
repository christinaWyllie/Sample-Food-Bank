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

public class TestHamperNutrition{
	//HAMPERNUTRITION TEST 
	
	/*@Test
	public void HamperNutritionImplementsCalculate(){
	//Tests for Hamper Nutrition
	HamperNutrition hamp = new HamperNutrition();
	assertTrue("HamperNutrition does not implement Calculate", (Calculate.class.isAssignableFrom(hamp.getClass())));
	}*/
			   
	//HAMPERNUTRITION TEST 
	@Test
	public void testCheckInventoryNotEnoughInventory()
	//tests that the NotEnoughInventoryExcpetion was thrown when there has not enough/any inventory avialable
	{
	boolean correctException = false;
	 try
	   {
		int g = 12;
		int p = 13;
		int f = 14;
		int o = 7;
		int c = 340;
		
		Nutrition n = new Nutrition(g, p, f, o, c);
		HamperNutrition hamp = new HamperNutrition(n);
		hamp.checkInventory();
		}
	catch(NotEnoughInventoryException e)
	{
		correctException = true;
	}
	assertTrue("NotEnoughInventory excpetion was not thrown when there is not enough inventory to create a hamper.", correctException);
}
	//HAMPERNUTRION TEST 
	@Test //FIX 
	public void testHamperNutritionConstructor() 
	{      
	int g = 12;
	int p = 13;
	int f = 14;
	int o = 7;
	int c = 340;
		
	Nutrition n = new Nutrition(g, p, f, o, c);
	HamperNutrition hamp = new HamperNutrition(n);
	
    	assertNotNull("HamperNutrition constructor did not create an object when given a nutrition object", hamp);
	//Initialize hamper linked list in constructor and should be null;
	assertNull("Hamper LinkedList was not null: ", hamp.getHamper());
	}
			   
	//HAMPERNUTRITION TEST
	@Test
	public void testHamperGetterAndSetters()
	{
	//Tests getHamper, addToHamper with one food item
	
	LinkedList<Food> expectedHamper = new LinkedList<Food>();
	Food f = new Food(10, 10, 10, 10, 10, 87, "Broccoli");
	expectedHamper.add(f);
	
	int g = 12;
	int p = 13;
	int f = 14;
	int o = 7;
	int c = 340;
		
	Nutrition n = new Nutrition(g, p, f, o, c);
	HamperNutrition hamp = new HamperNutrition(n);
	hamp.addToHamper(f);
	LinkedList<Food> hamper = hamp.getHamper();
	assertEquals("Method getHamper did not return the expected hamper: ", expectedHamper, hamp)
}

	//HAMPERNUTRITION TEST
	@Test
	public void testBestHamperCreatedExactHamper()
	{
	//Test createBestHamper(), getHamper()
	
	Food food1 = new Food(20, 30, 40, 10, 90, 87, "Broccoli");
	Food food2 = new Food(90, 10 , 0 , 0 , 100, 70, "Chocolate");
	Food food2 = new Food(0, 0, 13, 87, 130, 10, "Masala");
	
	LinkedList<Food> expectedBestHamper = new LinkedList<Food>();
	expectedBestHamper.add(food1);
	
	/*
	LinkedList<Food> inventory = newLinkedList<Food>();
	inventory.add(food1);
	inventory.add(food2);
	inventory.add(food3);*/
	
	createFoodHamperFamilyObjects();
	
	Nutrition n = new Nutrition(20, 30, 40, 10, 90);	//Mathces broccoli exactly, should choose broccoli
	HamperNutrition hamp = new Hamper Nutrition(n);
	hamp.setInventory(this.inventory);
	hamp.createBestHamper();
	
	LinkedList<Food> hamper = hamp.getHamper();
	assertEquals("Method getHamper did not return the expected hamper: ", expectedBestHamper, hamper);
}
			   
	//HAMPERNUTRITION TEST 
	@Test
	public void testBestHamperCreatedApproxHamper()
	{
	//Test createBestHamper(), getHamper()
	
	Food food1 = new Food(20, 30, 40, 10, 90, 87, "Broccoli");
	Food food2 = new Food(90, 10 , 0 , 0 , 100, 70, "Chocolate");
	Food food2 = new Food(0, 0, 13, 87, 130, 10, "Masala");
	
	LinkedList<Food> expectedBestHamper = new LinkedList<Food>();
	expectedBestHamper.add(food1);
	
	/*
	LinkedList<Food> inventory = newLinkedList<Food>();
	inventory.add(food1);
	inventory.add(food2);
	inventory.add(food3);
	*/
	
	createFoodHamperFamilyObjects();
	
	Nutrition n = new Nutrition(15, 25, 45, 15, 60);	//Best match for caloric intake is broccoli, should choose broccoli
	HamperNutrition hamp = new Hamper Nutrition(n);
	hamp.setInventory(this.inventory);
	hamp.createBestHamper();
	
	LinkedList<Food> hamper = hamp.getHamper();
	assertEquals("Method getHamper did not return the expected hamper: ", expectedBestHamper, hamper);
	}
	
	//HAMPERNUTRITION TEST 
	@Test
	public void testInventoryRemoved()
	{
	//Test removeInventory() which removes all food objects 
	//in hamper LinkedList from Food Linked List in Inventory class  
	
	Food food1 = new Food(10, 10, 10, 10, 10, 87, "Broccoli");
	Food food2 = new Food(90, 0 , 0 , 0 , 10, 700, "Chocolate");
	Food food2 = new Food(0, 0, 0, 87, 13, 100, "Masala");
	
	LinkedList<Food> expectedInventory = new LinkedList<Food>();
	expectedInventory.add(food2);
	expectedInventory.add(food3);
	/*
	LinkedList<Food> inventory = newLinkedList<Food>();
	inventory.add(food1);
	inventory.add(food2);
	inventory.add(food3);
	*/
	
	Nutrition n = new Nutrition(15, 25, 45, 15, 60);	//Should create a hmaper with broccoli and remove broccoli from inventory linked list
	HamperNutrition hamp = new Hamper Nutrition(n);
	hamp.setInventory(this.inventory)
	hamp.createBestHamper();
	hamp.removeInventory();
	LinkedList<Food> foundInventory = hamp.getInventory().getInventory();
	
	assertEquals("Method getInventory did not return the expected Inventory: ", expectedInventory, foundInventory);
	
}
}
