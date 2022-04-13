//* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestInventory.java
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
 *//
 
package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestInventoryAndDataBase{
	
	//INVENTORY TEST 
  	 @Test
  	 public void testInventoryConstructorWithValidDataBase(){
	//testing inventory with database
	   Inventory inv = new Inventory();
	   assertNotNull("Inventory object with invalid database connection was not null", inv);
	}
	
	//INVENTORY TEST
	@Test
	public void testInventoryGettersandSetters(){
	//tests the set methods for inventory, setCalories and setInventory
		Inventory i = new Inventory();
		int[][] array = new int[4][6];
		array[0][0] = 1;
		array[0][1] = 16;
		array[0][2] = 28;
		array[0][3] = 30;
		array[0][4] = 26;
		array[0][5] = 2500;
		
		array[1][0] = 2;
		array[1][1] = 16;
		array[1][2] = 28;
		array[1][3] = 26;
		array[1][4] = 30;
		array[1][5] = 2500;
		i.setCalorieTable(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		i.setInventory(list);
		
		LinkedList<Food> removallist= new LinkedList<Food>();
		removallist.add(food10);
		removallist.add(food11);
		i.setRemoveInventory(removallist);
		
		String s = "";
 
        // using iterator for traversing a linkedlist
 
        String expected = String.valueOf(food10.getFoodID());
        expected += String.valueOf(food11.getFoodID());
        for (int j = 0; j < i.getRemoveInventory().size(); j++)
        {
			s += String.valueOf(i.getRemoveInventory().get(j).getFoodID());
		}
        
        LinkedList<Food> actualInventory = i.getInventory();
        String expectedCalsTable = Arrays.deepToString(array);
        String actualCalsTable =Arrays.deepToString(i.getCalorieTable());
        LinkedList<Food> actualRemovedInventory = i.getRemoveInventory();
        
		
		
		assertEquals("Inventory inventory list does not match expected.",  list, actualInventory); //tests get inv
		assertEquals("Inventory calorie table does not match expected.", expectedCalsTable, actualCalsTable);
		assertEquals("Inventory removed inventory list does not match expected.", removallist, actualRemovedInventory);
		i.closeDataBase();
	}
	
	
	
	//INVENTORY TEST 
	@Test
	public void testInventoryRemoval(){
	//tests that the removemethod from invenotry correctly removes from the main inventory linked list
		Inventory i = new Inventory();
		int[][] array = new int[4][6];
		array[0][0] = 1;
		array[0][1] = 16;
		array[0][2] = 28;
		array[0][3] = 30;
		array[0][4] = 26;
		array[0][5] = 2500;
		
		array[1][0] = 2;
		array[1][1] = 16;
		array[1][2] = 28;
		array[1][3] = 26;
		array[1][4] = 30;
		array[1][5] = 2500;
		i.setCalorieTable(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		i.setInventory(list);
		
		LinkedList<Food> remove= new LinkedList<Food>();
		remove.add(food10);
		remove.add(food11);
		list.remove(0);
		list.remove(1);
		i.setRemoveInventory(remove);
		i.removeInventory();
		
		LinkedList<Food> actualRemoved = i.getRemoveInventory();
		LinkedList<Food> actualInv = i.getInventory();
		assertEquals("Inventory removed inventory list does not match expected.", remove, actualRemoved);
		assertEquals("Inventory inventory list does not match expected.",  list, actualInv);
		i.closeDataBase();
	}
			   
	//INVENTORY TEST
	@Test
	public void testRemoveDataBase(){
	//testing remove from datatbase method assuming valid database
	Inventory i = new Inventory();
	
	Food food1 = new Food(1, "Tomato Sauce, jar", 0, 96, 12, 12, 120);
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase();
	assertTrue("Inventory item was not removed from database.", status);
	i.closeDataBase();
	}
	
	//INVENTORY TEST
	@Test
	public void testRemoveDataBaseWithInvalidEntry(){
	//testing remove from datatbase method assuming valid database given an invalid id number for the entry
	Inventory i = new Inventory();
	
	Food food1 = new Food(200, "Tomato Sauce, jar", 0, 96, 12, 12, 120); //invalid id number
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase();
	assertFalse("Exception was not thrown when trying to remove an invalid database entry.", status);
	i.closeDataBase();
	}
	
	//INVENTORY TEST
	@Test
	public void testRemoveDataBaseWithMultipleValidEntries(){
	//testing remove from datatbase method assuming valid database with multiple valid entries
	Inventory i = new Inventory();
	
	Food food1 = new Food(4, "Apple, dozen", 0, 624, 0, 0, 624); 
	Food food2 = new Food(8, "Baby carrots, pound", 0, 159, 0, 0, 159); 
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	remove.add(food2);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase();
	assertTrue("Inventory items were not removed from database.", status);
	i.closeDataBase();
	}
	
	//INVENTORY TEST
	@Test
	public void testRemoveDataBaseWithMultipleInvalidEntries(){
	//testing remove from datatbase method assuming valid database with multiple entries that are invalid
	Inventory i = new Inventory();
	
	Food food1 = new Food(15, "Not a real food", 0, 864, 0, 0, 864); //wrong name
	Food food2 = new Food(323, "Baby carrots, pound", 0, 159, 0, 0, 159); //invalid id number
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	remove.add(food2);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase();
	assertFalse("Exception was not thrown when trying to remove an invalid database entry.", status);
	i.closeDataBase();
	}
}
