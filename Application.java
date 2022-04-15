/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Application.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.9
@since 1.0
 */

/*
Application Class: Main class which is connected to all classes important to the formation of a final order form
	- Constructor executes a sequence of commands that calls each class and forms the necessary requirements for a hamper to be created
	- Contains Inventory, HamperNutrition, and Family objects (compostition)
	- Application object is created within GUI when submit application button is pressed
*/


package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

public class Application{
  
  private int numHamper = 1; //int value that holds the size of hamper and family object (both hamper and family are the same size always)
  private Inventory inventory; //Inventory contains all the food items within the database (main access to the database)
  private ArrayList<Family> families; //Array that holds family objects where each family is a user input containing nutrition for amount of members specified
  private ArrayList<HamperNutrition> hamper; //Array that holds the "best hamper" for each family object specified (ArrayList for both families 
	//and hamper correspond to eachother i.e index 0 holds best hamper for Family in families[0]
	
  //private int[][] calorieInfo = {{1,30,20,40,10,2500}, {2,20,40,10,30,2500}, {3,21,33,31,15,2200}, {4,21,33,21,15,1400}};
  
	
  public Application() {} //Empty constructor 
	
/*
Application Constructor: 
	@param var: Raw input given from GUI each int[] is 4 elements matching Adult Male/Female and child over/under 8
	@exception NotEnoughInventoryException: Thrown from HamperNutrition class when DataBase does not contain enough elements to create a hamper
	@exception RemoveFromDataBaseFailedException: Thrown from OrderForm when DataBase runs into an error removing elements 
*/
  public Application(ArrayList<int[]> var) throws NotEnoughInventoryException, RemoveFromDataBaseFailedException {
    this.inventory = new Inventory();
    int[][] calorieTable = inventory.getCalorieTable(); //Gets daily nutritional needs for all client ID's (required for family to calculate nutritional needs)
	
    this.families = new ArrayList<Family>();
	for (int[] array : var) { //Iterates through var argument and inserts values into families object 
		this.families.add(new Family(array, calorieTable));
	}
	
	this.numHamper = families.size(); //How every many indicies var has is how many hampers we want to create 
	
	this.hamper = new ArrayList<HamperNutrition>();
	
	int i = 0;
	for (Family family : families) { //Iterates through family to fill hamper object by sending hamper nutritional needs of family and the inventory object to get foods
		this.hamper.add(new HamperNutrition(family.getTotal(), inventory));
		hamper.get(i).createBestHamper(); //Creates a hamper for every index inputted 
		i++;
		
	}
	OrderForm order = new OrderForm(families, inventory, hamper, numHamper); //Creates OrderForm object in order to print all families with their respective hampers
  }
  
  public int[] getUserInput(int index) {return this.families.get(index).getID();} //@param index: Gets the raw input from index specified which was inserted in families in 
  public int getNumHamper() {return this.numHamper;}
  public ArrayList<Family> getFamilies() {return this.families;}
  public ArrayList<HamperNutrition> getHampers() {return this.hamper;}
  public Family getFamily(int index) {return this.families.get(index);} //@param index: Gets the family object specified at index 
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();} //@param index: Gets the hamper created specified at index 
  public Inventory getInventory() {return this.inventory;}
  
}
