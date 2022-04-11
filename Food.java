/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Food.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.4
@since 1.0
 */

package edu.ucalgary.ensf409;

//public class Food which uses the calculate class
public class Food implements Calculate{
  private final String NAME;
  private final int FOODID;
  private final Nutrition NUTRITIONALVALUE;
  
//Food constructor
/*
* @param int itemID
* @param String n
* @param int g
* @param int f
* @param int p 
* @param int o
* @param int c
*/
  public Food(int itemID, String n, int g, int f, int p, int o, int c){
    this.NAME = n;
    this.NUTRITIONALVALUE = calculateContent(g,f,p,o,c);
    this.FOODID =itemID;
  }
  
//public getter method for the Nutrition object
  public Nutrition getNutritionalValue(){
    return this.NUTRITIONALVALUE;
  }

//public method to return the name
  public String getName() //added, not on UML
  {
	  return this.NAME;
  }
  
//public mehtod to return the food ID
  public int getFoodID(){
    return this.FOODID;
  }
  
// public method for the Calculate interface
  @Override //changed to return nutrition object, UML is fine for that part
  public Nutrition calculateContent(int g, int f, int p, int o, int c){ 
	 // calculates the total for each category by taking the percentage, dividing by 100 to get the decimal value and then multiply 
	  // by the total amount of calories for the food.
    int grain = (int)((g/100.0) * c);
    int fv = (int)((f/100.0) * c);
    int protein = (int)((p/100.0) * c);
    int other = (int)((o/100.0) * c);
    Nutrition toBeSet = new Nutrition(grain, fv, protein, other, c);
    return toBeSet;
  }
  
    
}
