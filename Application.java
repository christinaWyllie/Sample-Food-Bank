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

package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

public class Application{
  
  private int numHamper = 1;
  private Inventory inventory;
  private ArrayList<Family> families;
  private ArrayList<HamperNutrition> hamper;
  //private int[][] calorieInfo = {{1,30,20,40,10,2500}, {2,20,40,10,30,2500}, {3,21,33,31,15,2200}, {4,21,33,21,15,1400}};
  
  public Application() {}
  public Application(ArrayList<int[]> var) throws NotEnoughInventoryException, RemoveFromDataBaseFailedException {
    this.inventory = new Inventory();
    int[][] calorieTable = inventory.getCalorieTable();
	
    this.families = new ArrayList<Family>();
	for (int[] array : var) {
		this.families.add(new Family(array, calorieTable));
	}
	
	this.numHamper = families.size();
	
	this.hamper = new ArrayList<HamperNutrition>();
	
	int i = 0;
	for (Family family : families) {
		this.hamper.add(new HamperNutrition(family.getTotal(), inventory));
		hamper.get(i).createBestHamper();
		i++;
		
	}
	OrderForm order = new OrderForm(families, inventory, hamper, numHamper);
  }
  
  public int[] getUserInput(int index) {return this.families.get(index).getID();}
  public int getNumHamper() {return this.numHamper;}
  public ArrayList<Family> getFamilies() {return this.families;}
  public ArrayList<HamperNutrition> getHampers() {return this.hamper;}
  public Family getFamily(int index) {return this.families.get(index);}
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();}
  public Inventory getInventory() {return this.inventory;}
  
}
