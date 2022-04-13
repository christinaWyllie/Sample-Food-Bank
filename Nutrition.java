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

public class Nutrition{
  private final int GRAIN;
  private final int PROTEIN;
  private final int FV;
  private final int OTHER;
  private final int CALORIES;
  
/**
* @param int g
* @param int f
* @param int p 
* @param int o
* @param int c
*/
//class constructor to set all final values
  public Nutrition(int g, int f, int p, int o, int c)
  {
    this.GRAIN = g;
    this.PROTEIN = p;
    this.FV = f;
    this.OTHER = o;
    this.CALORIES = c;
  }
  
//method returns grain content
  public int getGrain(){
    return this.GRAIN;
  }
  //method returns protein content
  public int getProtein(){
    return this.PROTEIN;
  }
  //method returns fruits and veggie content
  public int getFV(){
    return this.FV;
  }
	
  //method returns other content
  public int getOther(){
    return this.OTHER;
  }
	
  //method returns total calorie content
  public int getCalories(){
    return this.CALORIES;
  }
}
  
  
