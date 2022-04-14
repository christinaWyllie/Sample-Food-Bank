//Inventory

/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Inventory.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.6
@since 1.0
 */
package edu.ucalgary.ensf409;

import java.util.*;

//class inventory that holds the inventory information obtained from the database and hold the list of items to 
//be removed. this class then calls the database to actually removed the items once it is determined that the order can 
//be fullfilled.
public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removeInventory = new LinkedList<Food>();
  private static int[][] calorieTable; 
  
//class constructor
  public Inventory(){
    this.dataAccess = new DataBase(); //creates new database object, which intitializes the connection to the database
    setInventory(this.dataAccess.getInventoryInfo()); //set inventory as the inventory read from db
    setCalorieTable(this.dataAccess.getCalorieInfo()); //set caloric information as table read from db
  }
  
//sets available inventory to a linked list
/**
* @param LinkedList<Food> i
*/
  public void setInventory(LinkedList<Food> i){
    this.inventory = i;
  }
  
//returns available inventory stored in the structure
  public LinkedList<Food> getInventory(){
    return this.inventory;
  }
  
//returns items that should be removed from inventory, but have not yet been removed 
  public LinkedList<Food> getRemoveInventory(){
    return this.removeInventory;
  }
  
//sets inventory to be removed to a linked list
/**
* @param LinkedList<Food> r
*/
  public void setRemoveInventory(LinkedList<Food> r)
  { 
	  this.removeInventory = r;
  }
  
//adds to the list of inventory to be removed without overwriting the previous entries
/**
* @param LinkedList<Food> r
*/
  public void addRemoveInventory(LinkedList<Food> r)
  { 
    for (int k = 0; k < r.size(); k++) //iterated through r and adds to removeInventory list
    {
      this.removeInventory.add(r.get(k));
    }
  }
  
//removes items from the inventory linked list that also appear in the removeInventory list
  public void removeInventory(){
    for (int k = 0; k < this.removeInventory.size(); k++)
    {
		  int tbr = removeInventory.get(k).getFoodID(); //gets food id
		
		  for (int p = 0; p < this.inventory.size(); p++)
		  {
			  if (this.inventory.get(p).getFoodID() == tbr) //if the ids for both match, then p will be removed from inventory linkedlist
			  {
				  inventory.remove(p);
			  }
		  }
	  }
  }
  
//removes objects that are in removeInventory from database using dataaccess object
  public boolean removeDataBase(){ 
    boolean success = this.dataAccess.updateDataBase(this.removeInventory); //calls database update method and passes removeInventory
    if (success == true) //if the removal was successful
    {
      this.removeInventory.clear(); //clears the removeInventory linked list because it is gone from database
    }
    return success;
  }
  
//returns the caloric needs of all possible family members
  public int[][] getCalorieTable(){
    return this.calorieTable;
  }
  
//sets the caloric needs
  public void setCalorieTable(int[][] s)
  {
    this.calorieTable = s;
  }
  
//closes the database connection, called after application is completed
  public void closeDataBase()
  {
	  this.dataAccess.close();
  }
}
