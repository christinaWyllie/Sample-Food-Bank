/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestNutritionAndFood.java
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


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestNutritionAndFood{
	
	//NUTRITION TEST
	@Test
	 //tests that nutrition and constructor return expected set values 
    	public void testGetNutritionConstructorSinglePersonDetails() {
   	int givenDataGrain = 400; //NO addition required for totals that are passed through
   	int givenDataFV = 700;
	int givenDataProtein = 650;
	int givenDataOther = 750;
	int givenDataCalories = 2500;
	
	Nutrition nutrition = new Nutrition(givenDataGrain, givenDataFV, givenDataProtein, givenDataOther, givenDataCalories); //create new nutrition object
		
	int actualContentGrain = nutrition.getGrain(); //uses nutriton getters
    	int actualContentProtein = nutrition.getProtein(); //uses nutriton getters
	int actualContentFV = nutrition.getFV(); //uses nutriton getters
	int actualContentOther = nutrition.getOther(); //uses nutriton getters
	int actualContentCalories = nutrition.getCalories(); //uses nutriton getters

   	assertEquals("Value of grains did not match what was expected: ", givenDataGrain, actualContentGrain);
	assertEquals("Value of protein did not match what was expected: ", givenDataFV, actualContentFV);
	assertEquals("Value of FV content did not match what was expected: ", givenDataProtein, actualContentProtein);
	assertEquals("Value of other nutrition did not match what was expected: ", givenDataOther, actualContentOther);
	assertEquals("Value of calories did not match what was expected: ", givenDataCalories, actualContentCalories);
    	}
	
	//FOOD TEST
	@Test
	//tests that the food constructor creates a valid object that is not null
	public void testFoodConstructor(){
	   Food food1 = new Food(1, "Wheat bread, loaf", 96, 0, 4, 0, 2192);
	   assertNotNull("Food did not create a valid object.", food1);
   	}
			   
	//FOOD AND NUTRITION TEST 
  	 @Test
	//tests that the getters in food returns the expected nutrition object, and that that nutrition objects getters return the correct values
   	public void testFoodAndNutritionGetters(){
	   int expectedid = 2;
	   Food food1 = new Food(expectedid, "Granola Bar, 1 box", 12, 12, 56, 20, 1000);
	   int gval = (int)((g1/100.0) * c1);
	   int fval = (int)((f1/100.0) * c1);
	   int pval = (int)((p1/100.0) * c1);
	   int oval = (int)((o1/100.0) * c1);
	   Nutrition expected = new Nutrition(gval, fval, pval, oval, c1);
	   Nutrition actual = food1.getNutritionalValue(); //tests nutrition getter
	   int actualID = food1.getFoodID(); //tests foodid getter
	   assertEquals("Value of grains did not match what was expected: ", gval, actual.getGrain()); //tests getter within nutrition
	   assertEquals("Value of protein did not match what was expected: ", pval, actual.getProtein());//tests getter within nutrition
	   assertEquals("Value of FV content did not match what was expected: ", fval, actual.getFV());//tests getter within nutrition
	   assertEquals("Value of other nutrition did not match what was expected: ", oval, actual.getOther());//tests getter within nutrition
	   assertEquals("Value of calories did not match what was expected: ", c1, actual.getCalories());//tests getter within nutrition
	   assertEquals("Food ID does not match expected.", expectedid, actualID); //tests that id number is valid
   	}
	
   	@Test
	//tests that the Food class implements the Calculate interface
  	 public void testFoodImplementsCalculate(){
	   Food food1 = new Food(1, "Wheat bread, loaf", 96, 0, 4, 0, 2192);
	   assertTrue("Food does not implement Calculate", (Calculate.class.isAssignableFrom(food1.getClass())));
	}
}
