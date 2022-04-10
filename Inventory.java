/* 
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

public class Inventory{
  private DataBase dataAccess;
  private static LinkedList<Food> inventory;
  private static LinkedList<Food> removeInventory = new LinkedList<Food>();
  private static int[][] calorieTable; 
  
  public Inventory(){
    this.dataAccess = new DataBase();
    setInventory(this.dataAccess.getInventoryInfo());
    setCalorieTable(this.dataAccess.getCalorieInfo());
  }
  
  public void setInventory(LinkedList<Food> i){
    this.inventory = i;
  }
  
  public LinkedList<Food> getInventory(){
    return this.inventory;
  }
  
  public LinkedList<Food> getRemoveInventory(){
    return this.removeInventory;
  }
  
  public void setRemoveInventory(LinkedList<Food> r)
  { 
    for (int k = 0; k < r.size(); k++)
    {
      this.removeInventory.add(r.get(k));
    }
  }
  
  public void removeInventory(){
    for (int k = 0; k < this.removeInventory.size(); k++)
    {
		  int tbr = removeInventory.get(k).getFoodID();
		
		  for (int p = 0; p < this.inventory.size(); p++)
		  {
			  if (this.inventory.get(p).getFoodID() == tbr)
			  {
				  inventory.remove(p);
			  }
		  }
	  }
  }
  
  public boolean removeDataBase(){ //only function not tested yet bc no database
    boolean success = this.dataAccess.updateDataBase(this.removeInventory);
    if (success == true)
    {
      this.removeInventory.clear();
    }
    return success;
  }
  
  public int[][] getCalorieTable(){
    return this.calorieTable;
  }
  
  public void setCalorieTable(int[][] s)
  {
    this.calorieTable = s;
  }
}
