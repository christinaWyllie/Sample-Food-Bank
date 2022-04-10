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

public class Application{
  
  private int numHamper = 1;
  private Iventory inventory;
  private ArrayList<Family> families;
  private ArrayList<HamperNutrition> hamper;
  
  public Application(int[] var){
    this.inventory = new Inventory();
    int[][] calorieTable = inventory.getCalorieTable();
    this.families = new ArrayList<Family>();
    this.families.add(new Family(var, calorieTable));
    this.hamper = new ArrayList<HamperNutrition>();
    this.hamper.add(new HamperNutrition(this.families.get(numHampers-1).getTotal())); //What nutriton object do I send in?
  }
 
  public void addHamper(int[] var) {
     this.numHampers++;
     this.families.add(new Family(var, this.inventory.calorieTable()));
     this.hamper.add(new HamperNutrition(this.families.get(numHampers-1).getTotal())); //Still dont know what nutriton object im sending 
  }
  
  public int[] getUserInput(int index) {return this.families.get(index).getFamilyMembers();}
  public int getNumHamper() {return this.numHamper;}
  public ArrayList<Family> getFamiles() {return this.familes;}
  public Arraylist<HamperNutrition> getHampers() {return this.hamper;}
  public Family getFamily(int index) {return this.familes.get(index);}
  public LinkedList<Food> getHamper(int index) {return this.hamper.get(index).getHamper();}
  public Inventory getInventory() {return this.inventory;}
}
