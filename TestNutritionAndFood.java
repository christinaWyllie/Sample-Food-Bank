/* 
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
    public void testGetNutritionSinglePerson() {
        //tests getters when only one person is given to the application 
	//NO addition required for total grains 
        int givenDataGrain = 400;
        int givenDataFV = 700;
	int givenDataProtein = 650;
	int givenDataOther = 750;
	int givenDataCalories = 2500;
		
	int[] array = [1,0,0,0];
	Nutrition nutrition = new Nutrition(givenDataGrain, givenDataProtein, givenDataFV, givenDatOther, givenDataCalories);
		
	int actualContentGrain = nutrition.getGrain();
        int actualContentProtein = nutrition.getProtein();
	int actualContentFV = nutrition.getFV();
	int actualContentOther = nutrition.getOther();
	int actualContentCalories = nutrition.getCalories();
        

        assertEquals("Value of grains did not match what was expected: ", givenDataGrain, actualContentGrain);
	assertEquals("Value of protien did not match what was expected: ", givenDataFV, actualContentFV);
	assertEquals("Value of FV content did not match what was expected: ", givenDataProtein, actualContentProtien);
	assertEquals("Value of other nutrition did not match what was expected: ", givenDataOther, actualContentOther);
	assertEquals("Value of calories did not match what was expected: ", givenDataCalories, actualContentCalories);
    }
	
	//FOOD TEST
	@Test
	public void testFoodConstructorandGetter(){
	//tests that the food constructor creates a valid object
	   String name1= "Wheat bread, loaf";
	   int id = 1;
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = Food(id, name1, g1, f1, p1, o1, c1);
	   assertNotNull("Food did not create a valid object.", food1);
   	}
			   
	//FOOD TEST 
  	 @Test
   	public void testFoodGetters(){
	//tests that the getters in food returns the expected nutrition object
	   String name1= "Granola Bar, 1 box";
	   int expectedid  2;
	   int g1 = 12;
	   int f1 = 12;
	   int p1 = 56;
	   int o1 = 20;
	   int c1 = 1000;
	   Food food1 = Food(expectedid, name1, g1, f1, p1, o1, c1);
	   int gval = (int)((double)(g1/100) * c1));
	   int fval = (int)((double)(f1/100) * c1));
	   int pval = (int)((double)(p1/100) * c1));
	   int oval = (int)((double)(o1/100) * c1));
	   Nutrition expected = Nutrition(gval, pval, fval, oval, c1);
	   Nutrition actual = food1.getNutritionValue();
	   int actualID = food1.getFoodID();
	   assertEquals("Food's getNutritionValue did not return the expected nutrition object.", expected, actual); 
	   assertEquals("Food ID does not match expected.", actualID, expectedid) 
   }
}