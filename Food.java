/**
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

/**
 * This class is the class that stores data from the database to be ready for
 * use by other classes. This class calculates then stores the amount of calories in a 
 * nutrition object in number amounts, after being sent percentage amounts from the
 * database. Food implements the Calculate interface to generate the total calorie
 * amounts.
 */
public class Food implements Calculate{
  private final String NAME;
  private final int FOODID;
  private final Nutrition NUTRITIONALVALUEP;
  private final int GRAINP;
  private final int FVP;
  private final int PROTEINP;
  private final int OTHERP;
  private final int CALORIES;
  

/**
* Sole class constructor than sets all final values, then calls calculate content to
* turn percentage values into caloric amounts that are then sent and stored in a 
* nutrition object.
* 
* @param itemID		the unique itemID, as stored in the database
* @param n			the name of the food, as stored in the database
* @param g			percentage of grain content, as stored in database
* @param f			percentage of fruit and veggie content, as stored in database
* @param p 			percentage of protein content, as stored in database
* @param o			percentage of other content, as stored in database
* @param c			total caloric content, as stored in database
*/
  public Food(int itemID, String n, int g, int f, int p, int o, int c){
    this.NAME = n;
    this.GRAINP = g; //grain percentage
    this.FVP = f; //fv percentage
    this.PROTEINP = p;	//protein percentage
    this.OTHERP = o; //other percentage
    this.CALORIES = c;
    
    this.NUTRITIONALVALUE = calculateContent();
    this.FOODID =itemID;
  }
  

/**
 * Public getter method to return the nutrtion object containing caloric
 * information for the food.
 * 
 * @return NUTRITIONALVALUE 	nutritition object
 */
  public Nutrition getNutritionalValue(){
    return this.NUTRITIONALVALUE;
  }

/**
 * Public getter method to return the name of the food.
 * 
 * @return NAME		name of the food as it is stored in the database
 */
  public String getName() 
  {
	  return this.NAME;
  }
  

/**
 * Public getter method to return the unique itemID of the food item.
 * 
 * @return FOODID		FoodID as it is stored in the database
 */
  public int getFoodID(){
    return this.FOODID;
  }
  

/**
 * Public method from the calculate interface that calculates 
 * the total for each category by taking the percentage, dividing by 
 * 100 to get the decimal value and then multiply by the total amount of 
 * calories for the food. this is then stored in a nutrition object within food.
 * 
 * @return toBeSet		nutrition object that is returned to the constructor to be set as a final value
 */
  @Override 
  public Nutrition calculateContent(){ 
    int grain = (int)((this.GRAINP/100.0) * this.CALORIES);
    int fv = (int)((this.FVP/100.0) * this.CALORIES);
    int protein = (int)((this.PROTEINP/100.0) * this.CALORIES);
    int other = (int)((this.OTHERP/100.0) * this.CALORIES);
    Nutrition toBeSet = new Nutrition(grain, fv, protein, other, this.CALORIES);
    return toBeSet;
  }
  
}
