/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: Nutrition.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.3
@since 1.0
 */
 
package edu.ucalgary.ensf409;

/**
 * This class serves as a container class that holds nutrition information
 * in actual calorie amounts rather than percentages that is accessed by many
 * classes in the program such as Family, Food and HamperNutrition to access
 * the caloric needs of the food or family.
 */
 
public class Nutrition{
  private final int GRAIN;
  private final int PROTEIN;
  private final int FV;
  private final int OTHER;
  private final int CALORIES;
  
/**
* Sole class constructor to set all final values.
* 
* @param g	grain content required
* @param f	fruits and veggie content required
* @param p	protein content required
* @param o	other content required
* @param c	total calorie content required
*/
  public Nutrition(int g, int f, int p, int o, int c)
  {
    this.GRAIN = g;
    this.PROTEIN = p;
    this.FV = f;
    this.OTHER = o;
    this.CALORIES = c;
  }
  
/**
 * Method that returns grain content stored within object.
 * 
 * @return grain calorie amount required
 */
  public int getGrain(){
    return this.GRAIN;
  }

/**
 * Method that returns protein content stored within object.
 * 
 * @return protein calorie amount required
 */
  public int getProtein(){
    return this.PROTEIN;
  }
/**
 * Method that returns fruit and veggie content stored within object.
 * 
 * @return fruit and veggie calorie amount required
 */
  public int getFV(){
    return this.FV;
  }
	
/**
 * Method that returns other calorie content stored within object.
 * 
 * @return other calorie amount required
 */
  public int getOther(){
    return this.OTHER;
  }
	
/**
 * Method that returns total calorie content stored within object.
 * 
 * @return total calorie amount required
 */
  public int getCalories(){
    return this.CALORIES;
  }
}
