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

/**
 * This class holds the inventory information obtained from the database and holds the list of
 * items to be removed from the database. This class, after all hampers in an application are
 * confirmed to be able to be fullfilled is then able to remove the items from the database.
 */
public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removeInventory = new LinkedList<Food>();
  private static int[][] calorieTable; 
  

/**
 * Sole class constructor that initializes a DataBase object and sets the information read
 * from the database to private static variables that are tehn accessed by other classes 
 * throughout the program.
 */
  public Inventory(){
    this.dataAccess = new DataBase(); //creates new database object, which intitializes the connection to the database
    setInventory(this.dataAccess.getInventoryInfo()); //set inventory as the inventory read from db
    setCalorieTable(this.dataAccess.getCalorieInfo()); //set caloric information as table read from db
  }
  

/**
 * Public method that sets the inventory linkedlist in the class to available food items.
 * 
* @param i	linked list of food objects that serves as a representation of what is available in the database
*/
  public void setInventory(LinkedList<Food> i){
    this.inventory = i;
  }
  

/**
 * Public method that returns the inventory linkedlist in the class of available food items.
 * 
* @return 	returns a linked list of food objects that serves as a representation of what is available in the database
*/
  public LinkedList<Food> getInventory(){
	Iterator<Food> it = this.inventory.iterator(); //creates deep copy to return to other classes
	LinkedList<Food> invCopy = new LinkedList<Food>();
		
	while(it.hasNext())
	{
		invCopy.add(it.next());
	}
		
	return invCopy;
  }
  

/**
 * Public method that returns the linkedlist in the class of food items that are not available (ie. used 
 * in a hamper) but have not yet been removed from the database.
 * 
* @return	returns a linked list of food objects that to be removed from the database
*/
  public LinkedList<Food> getRemoveInventory(){
	Iterator<Food> it = this.removeInventory.iterator(); //creates deep copy to return to other classes
	LinkedList<Food> rCopy = new LinkedList<Food>();
		
	while(it.hasNext())
	{
		rCopy.add(it.next());
	}
		
	return rCopy;
  }
  

/**
 * Public method that sets the inventory that should be removed from the database, 
 * overwriting what was previously there. 
 * 
* @param r	linked list of food objects that to be removed from the database
*/
  public void setRemoveInventory(LinkedList<Food> r)
  { 
	  this.removeInventory = r;
  }


/**
 * Public method that adds to the already existing list of inventory to be removed without
 * overwriting the previous list. This method is primarlity used in the creation of multiple hampers.
 * 
* @param r  linked list of food objects that to be removed from the database
*/
  public void addRemoveInventory(LinkedList<Food> r)
  { 
    for (int k = 0; k < r.size(); k++) //iterated through r and adds to removeInventory list
    {
      this.removeInventory.add(r.get(k));
    }
  }
  

/**
 * Public method that removes the items that appear in the removeInventory linked list
 * from the main inventory linked list, so that the inventory linked list only contains
 * items that are available for use in a hamper.
 */
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
  

/**
 * This method removes objects that are in the removeInventory linked list
 * from the database, using the connection established in the DataBase class.
 * If the removal is successful, the removeInventory list is cleared.
 * 
 * @return 	returns true if database removal was successful
 */
  public boolean removeDataBase(){ 
    boolean success = this.dataAccess.updateDataBase(this.removeInventory); //calls database update method and passes removeInventory
    if (success == true) //if the removal was successful
    {
      this.removeInventory.clear(); //clears the removeInventory linked list because it is gone from database
    }
    return success;
  }
  

/**
 * This method returns the caloric information read from the database and passes
 * the information to other classes that require it, in order to avoid passing the
 * DataBase object around. 
 * 
 * @return 	returns the caloric needs of all possible family members
 */
  public int[][] getCalorieTable(){
    return this.calorieTable;
  }
  

/**
 * This method sets the caloric information of all possible family 
 * members that is read from the database.
 * 
 * @param s  integer array of the caloric needs of all possible family members
 */
  public void setCalorieTable(int[][] s)
  {
    this.calorieTable = s;
  }
  

/**
 * This method closes the connection to the database through the DataBase object,
 * called after the application is completed.
 */
  public void closeDataBase()
  {
	  this.dataAccess.close();
  }
}
