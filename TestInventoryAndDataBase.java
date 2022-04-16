/**
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
 */
 
package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/*
*****************************************************READ ME**************************************************************
These tests test removal from the database as well as inventory since the two classes are interconnected. 
The values in the tests that pertain to the database are valid in the test database, and thus are able to be removed.
If the database that the tests are connected to is changed, these test values would also need to be changed to reflect 
that. Since the tests remove from the database, if the tests are successful the first time they are run, the database
will be altered and these items will no longer exist, so the tests will fail the second time they are run in 
succession. Thus, if the tests are run twice, please reset the database to its initial state in between runs.
*/

public class TestInventoryAndDataBase{
	
	//INVENTORY TEST 
  	 @Test
	//testing that inventory connects to the database and creates a valid object
  	 public void testInventoryConstructorWithValidDataBase(){
	
	   Inventory inv = new Inventory();
	   assertNotNull("Inventory object with invalid database connection was not null", inv);
	}
	
	//INVENTORY TEST
	@Test
	//tests the set methods for inventory, setCalories and setInventory and get methods as well to see how they are returned
	//by the getters 
	public void testInventoryGettersandSetters(){
		Inventory i = new Inventory(); //initializes inventory object
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
		i.setCalorieTable(array); //sets calorie table
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>(); //create new linked list of food to act as inventory linked list
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		i.setInventory(list); //set inventory to our list
		 
		LinkedList<Food> removallist= new LinkedList<Food>(); //create small ll to act as sample hamper/remove list
		removallist.add(food10);
		removallist.add(food11);
		i.setRemoveInventory(removallist);//set removeinventory to our list
        
        LinkedList<Food> actualInventory = i.getInventory(); //get the inventory from the object to see what is stored
        String expectedCalsTable = Arrays.deepToString(array); 
        String actualCalsTable =Arrays.deepToString(i.getCalorieTable());//get cals table
        LinkedList<Food> actualRemovedInventory = i.getRemoveInventory(); //gets remove list
    
		assertEquals("Inventory inventory list does not match expected.",  list, actualInventory); //tests getinv
		assertEquals("Inventory calorie table does not match expected.", expectedCalsTable, actualCalsTable); //tests getcalstable
		assertEquals("Inventory removed inventory list does not match expected.", removallist, actualRemovedInventory); //tests getremoveinventory
		i.closeDataBase();
	}
	
	
	
	//INVENTORY TEST 
	@Test
	//tests that removeInventory correctly removes from the main inventory linked list 
	public void testInventoryRemovalAndAddToRemoveInventoryMethod(){
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
		
		LinkedList<Food> list= new LinkedList<Food>();//create our own inv list to test with
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		i.setInventory(list);
		
		LinkedList<Food> remove= new LinkedList<Food>(); //create list of food to set inventory as (acts like first hamper)
		remove.add(food10);
		i.setRemoveInventory(remove); //sets remove inventory
		
		LinkedList<Food> testAddtoMethod= new LinkedList<Food>(); //create new linked list to add to the exisiting removeInventory ll (acts as second hamper)
		testAddtoMethod.add(food11); 
		
		i.addRemoveInventory(testAddtoMethod);//tests adds to exisiting removeInventory list
		
		list.remove(0);
		list.remove(1);
		
		i.removeInventory(); //calls this method to make sure inventory linked list in i is updated and all duplicates in removeInventory list are removed from it
		
		LinkedList<Food> actualRemoved = i.getRemoveInventory(); //actual removed inventory
		LinkedList<Food> actualInv = i.getInventory(); //actual inventory
		assertEquals("Inventory removed inventory list does not match expected.", remove, actualRemoved);
		assertEquals("Inventory inventory list does not match expected.",  list, actualInv);
		i.closeDataBase();
	}
			   
	//INVENTORY AND DATABASE TEST
	@Test
	//testing remove from datatbase method assuming valid database, and only 1 entry that is a valid entry in the database
	public void testRemoveDataBase(){
	Inventory i = new Inventory();
	
	Food food1 = new Food(1, "Tomato Sauce, jar", 0, 96, 12, 12, 120);
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	i.setRemoveInventory(remove); //sets this linked list as the list to be removed
		
	boolean status = i.removeDataBase(); //method should remove the linked list from the database
	assertTrue("Inventory item was not removed from database.", status);
	i.closeDataBase();
	}
	
	//INVENTORY AND DATABASE TEST
	@Test
	//testing remove from datatbase method assuming valid database given an invalid id number for the entry
	public void testRemoveDataBaseWithInvalidEntry(){
	Inventory i = new Inventory();
	
	Food food1 = new Food(200, "Tomato Sauce, jar", 0, 96, 12, 12, 120); //invalid id number
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase();
	assertFalse("Exception was not thrown when trying to remove an invalid database entry.", status);
	i.closeDataBase();
	}
	
	//INVENTORY AND DATABASE TEST
	@Test
	//testing remove from database method assuming valid database with multiple valid entries being removed
	public void testRemoveDataBaseWithMultipleValidEntries(){
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
	
	//INVENTORY AND DATABASE TEST
	@Test
	//testing remove from database method assuming valid database with multiple entries that are invalid
	public void testRemoveDataBaseWithMultipleInvalidEntries(){
	Inventory i = new Inventory();
	
	Food food1 = new Food(15, "Not a real food", 0, 864, 0, 0, 864); //wrong name
	Food food2 = new Food(323, "Baby carrots, pound", 0, 159, 0, 0, 159); //invalid id number
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	remove.add(food2);
	i.setRemoveInventory(remove);
		
	boolean status = i.removeDataBase(); //remove from database method is called
	assertFalse("Exception was not thrown when trying to remove an invalid database entry.", status);
	i.closeDataBase();
	}
}
