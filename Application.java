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

public class Application{
  
  private int numHamper = 1;
  private Inventory inventory;
  private ArrayList<Family> families;
  private ArrayList<HamperNutrition> hamper;
  
  public Application() {}
  public Application(ArrayList<int[]> var){
    this.inventory = new Inventory();
    int[][] calorieTable = inventory.getCalorieTable();
    this.families = new ArrayList<Family>();
	for (int[] array : var) {
		this.families.add(new Family(array, calorieTable));
	}
    this.hamper = new ArrayList<HamperNutrition>();
    this.hamper.add(new HamperNutrition(this.families.get(numHampers-1).getTotal()));
  }
  
  public int[] getUserInput(int index) {return this.families.get(index).getFamilyMembers();}
  public int getNumHamper() {return this.numHamper;}
  public ArrayList<int[]> getFamilies() {return this.families;}
  public Arraylist<HamperNutrition> getHampers() {return this.hamper;}
  public int[] getFamily(int index) {return this.families.get(index);}
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();}
  public Inventory getInventory() {return this.inventory;}
  
}
