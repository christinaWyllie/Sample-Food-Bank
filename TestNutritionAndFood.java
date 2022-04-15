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
	
	//NUTRITION TESTS
	@Test
	//This test tests that the nutrition constructor creates and returns a valid object
    public void testtNutritionConstructor() {
	int givenDataGrain = 400;
    	int givenDataFV = 700;
	int givenDataProtein = 650;
	int givenDataOther = 750;
	int givenDataCalories = 2500; 
	    
	Nutrition nutrition = new Nutrition(givenDataGrain, givenDataFV, givenDataProtein, givenDataOther, givenDataCalories);
	 assertNotNull("The Nutriton object created by the constructor is null.", nutrition);
    }
	    
	//NUTRITION TESTS
	@Test
    public void testNutritionGetters() {
    //tests getters when only one person is given to the application 
	//NO addition required for totals, since nutrition is a container class
    	int givenDataGrain = 400;
    	int givenDataFV = 700;
	int givenDataProtein = 650;
	int givenDataOther = 750;
	int givenDataCalories = 2500; 
	    
	Nutrition nutrition = new Nutrition(givenDataGrain, givenDataFV, givenDataProtein, givenDataOther, givenDataCalories);
		
	int actualContentGrain = nutrition.getGrain();
    	int actualContentProtein = nutrition.getProtein();
	int actualContentFV = nutrition.getFV();
	int actualContentOther = nutrition.getOther();
	int actualContentCalories = nutrition.getCalories();
        
	//assert that all getters return the correct values that are set by the constructor in nutrition
   	assertEquals("Value of grains does not match what was expected: ", givenDataGrain, actualContentGrain);
	assertEquals("Value of protein does not match what was expected: ", givenDataFV, actualContentFV);
	assertEquals("Value of FV content does not match what was expected: ", givenDataProtein, actualContentProtein);
	assertEquals("Value of other nutrition does not match what was expected: ", givenDataOther, actualContentOther);
	assertEquals("Value of calories does not match what was expected: ", givenDataCalories, actualContentCalories);
    }
	
	//FOOD TEST
	@Test
	public void testFoodConstructor(){
	//tests that the food constructor creates a valid object
	   String name1= "Wheat bread, loaf";
	   int id = 1;
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = new Food(id, name1, g1, f1, p1, o1, c1);
	   assertNotNull("Food constructor does not create a valid object.", food1);
   	}
			   
	//FOOD TEST 
  	 @Test
   	public void testFoodGettersAndCalculateContentMethod(){
	//tests that the getters in food returns the expected nutrition object, and values that were set percentage wise by food
	   String name1= "Granola Bar, 1 box";
	   int expectedid = 2;
	//these values are percentages
	   int g1 = 12;
	   int f1 = 12;
	   int p1 = 56;
	   int o1 = 20;
	   int c1 = 1000;
	   Food food1 = new Food(expectedid, name1, g1, f1, p1, o1, c1);
	//these are expected values, Food should return the same values as calculated in the calculateContent method
	   int gval = (int)((g1/100.0) * c1);
	   int fval = (int)((f1/100.0) * c1);
	   int pval = (int)((p1/100.0) * c1);
	   int oval = (int)((o1/100.0) * c1);
	   Nutrition expected = new Nutrition(gval, fval, pval, oval, c1);
	   Nutrition actual = food1.getNutritionalValue();
	   int actualID = food1.getFoodID();
	   String actualName = food1.getName();
	
		//asserts that the getters within food getNutrtionalValue(), and getName() and getFoodID() match expected results
		//also checks that the values produced by the calculateContent method that are then stored in the nutrition 
		//object are correct and match the expected
	    assertEquals("Value of grains does not match what was expected: ", gval, actual.getGrain());
		assertEquals("Value of protein does not match what was expected: ", pval, actual.getProtein());
		assertEquals("Value of FV content does not match what was expected: ", fval, actual.getFV());
		assertEquals("Value of other nutrition does not match what was expected: ", oval, actual.getOther());
		assertEquals("Value of calories does not match what was expected: ", c1, actual.getCalories());
		assertEquals("Food ID does not match expected.", expectedid, actualID);
		assertEquals("Name of food does not match expected.", name1, actualName);
   }
   @Test
   public void testFoodImplementsCalculate(){
	//tests that the Food class implements the Calculate interface
	String name1= "Wheat bread, loaf";
	   int id = 1;
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = new Food(id, name1, g1, f1, p1, o1, c1);
	assertTrue("Food does not implement Calculate", (Calculate.class.isAssignableFrom(food1.getClass())));
	}
}
