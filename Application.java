/**
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


package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

/**
 * The Application Class  is the main class which is connected to all classes important 
 * to the formation of a final order form. The constructor executes a sequence of commands 
 * that calls each class and forms the necessary requirements for a hamper to be created.
 * The class contains Inventory, HamperNutrition, and Family objects (compostition).
 * The Application object is created within GUI when the submit application button is pressed.
*/
public class Application{
  
  private int numHamper = 1; //int value that holds the size of hamper and family object (both hamper and family are the same size always)
  private Inventory inventory; //Inventory contains all the food items within the database (main access to the database)
  private ArrayList<Family> families; //Array that holds family objects where each family is a user input containing nutrition for amount of members specified
  private ArrayList<HamperNutrition> hamper; //Array that holds the "best hamper" for each family object specified (ArrayList for both families 
	//and hamper correspond to eachother i.e index 0 holds best hamper for Family in families[0]
  private OrderForm order;
	
  //private int[][] calorieInfo = {{1,30,20,40,10,2500}, {2,20,40,10,30,2500}, {3,21,33,31,15,2200}, {4,21,33,21,15,1400}};
  
	/**
	 * Empty constructor that can be called to initialize values, without passing in
	 * an arraylist of families.
	 */
  public Application() {} //Empty constructor 
	
/**
 * This method is the primary Application Constructor that is used to create the hampers and order
 * form per application, as imputted by the GUI.
 * 
 * @param var 	raw input given from GUI each int[] is 4 elements matching Adult Male/Female and child over/under 8
 * @exception 	NotEnoughInventoryException is thrown from HamperNutrition class when DataBase does not contain enough elements to create a hamper
 * @exception 	RemoveFromDataBaseFailedException is thrown from OrderForm when DataBase runs into an error removing elements 
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
	this.order = new OrderForm(families, inventory, hamper, numHamper); //Creates OrderForm object in order to print all families with their respective hampers
	order.removeFromDataBase();
		
	}
  
  /**
   * This method returns an integer array of user given input that was specified
   * originally by the user, then passed to create a Family object.
   * 
   * @param index 	gets the raw input from index specified
   * @return 	an integer array of the original input given by user that was inserted in that families index
   */
  public int[] getUserInput(int index) {return this.families.get(index).getID();}

/**
 * This method returns the number of hampers that were created and 
 * processed by this aplication.
 * 
 * @return the number of hampers created in this application	
 */
  public int getNumHamper() {return this.numHamper;}
	
/**
 * This method returns the arraylist that was originally passed to the 
 * constructor that contains all of the families being processed in this
 * application. The ArrayList contains one or more families depending on
 * how many orders were inputted in the GUI.
 * 
 * @return 	returns the families object in application
 */
  public ArrayList<Family> getFamilies() {return this.families;}

/** 
 * This method returns the hamper objects that were created through the
 * application. The ArrayList contains one or more hampers depending on
 * how many orders were inputted in the GUI.
 * 
 * @return 	hamper objects in application
 */
  public ArrayList<HamperNutrition> getHampers() {return this.hamper;}
	
/**
 * This method accesses and returns a specific family identified by 
 * an index within the arraylist of families object.
 * 
 * @param index 	specifies which index to access in families 
 * @return 	Family object at specified index 
 */
  public Family getFamily(int index) {return this.families.get(index);}

/**
 * This method accesses and returns a specific hamper identified by an 
 * index within the arraylist of hampers that have been created.
 * 
 * @param index		specifies which index to access in hamper 
 * @return 	"best hamper" created for the index given
 */ 
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();} 
	
/**
 * This method returns the inventory object that was created within the 
 * application.
 * 
 * @return 	inventory object in application
 */
  public Inventory getInventory() {return this.inventory;}
}
 


