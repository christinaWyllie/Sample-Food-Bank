/* 
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

public class TestInventory{
	//INVENTORY TEST 
  	 @Test
  	 public void testInventoryConstructorWithInvalidDataBase(){
	//testing inventory with no database
	   Inventory inv = new Inventory();
	   assertNull("Inventory object with invalid database connection was not null", inv);
	}
	
	//INVENTORY TEST
	@Test
	public void testInventorySetters(){
	//tests the set methods for inventory, setCalories and setInventory
		Inventory inventory = new Inventory();
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
		inventory.setCalories(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		inventory.setInventory(list);
		
		LinkedList<Food> removallist= new LinkedList<Food>();
		removallist.add(food10);
		removallist.add(food11);
		inventory.setRemoveInventory(removallist);
		
		assertEquals("Inventory inventory list does not match expected.", inventory.getInventory(), list);
		assertEquals("Inventory calorie table does not match expected.", inventory.getCalorieTable(), array);
		assertEquals("Inventory removed inventory list does not match expected.", inventory.getRemovedInventory(), removallist);
	}
	//INVENTORY TEST 
	@Test
	public void testInventoryRemoval(){
	//tests that the removemethod from invenotry correctly removes from the main inventory linked list
		Inventory inventory = new Inventory();
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
		inventory.setCalories(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		inventory.setInventory(list);
		
		LinkedList<Food> remove= new LinkedList<Food>();
		remove.add(food10);
		remove.add(food11);
		list.remove(0);
		list.remove(1);
		inventory.setRemoveInventory(remove);
		inventory.removeInventory();
		
		LinkedList<Food> actualRemoved = inventory.getRemovedInventory();
		LinkedList<Food> actualInv = inventory.getInventory();
		assertEquals("Inventory removed inventory list does not match expected.", actualRemoved, remove);
		assertEquals("Inventory inventory list does not match expected.", actualInv, list);
	}
			   
	//INVENTORY TEST
	@Test
	public void testRemoveDataBase(){
	//testing remove from datatbase method assuming valid database
	Inventory inventory = new Inventory();
	String name1= "Wheat bread, loaf";
	int id = 1;
	int g1 = 96;
	int f1 = 0;
	int p1 = 4;
	int o1 = 0;
	int c1 = 2192;
	Food food1 = Food(id, name1, g1, f1, p1, o1, c1); //assuming this a valid entry in database
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	inventory.setRemoveInventory(remove);
	inventory.removeInventory();
		
	boolean status = inventory.removeDataBase();
	assertTrue("Inventory item was not removed from database.", status);
	}
}