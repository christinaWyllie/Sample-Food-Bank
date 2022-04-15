/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestApplication.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.5
@since 1.0
 */
 
package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestApplication{
	
	//APPLICATION TEST 
	@Test
    public void testApplicationConstructor() {
    //Num hampers creates default values
		//family object created and returns array list with one index inside
		//HamperNutrition object created and returns array list with one index 
		//Inventory object expected to contain all inventory
    //Array reads in as [Adult male, adult female, child under 8, child over 8]
		// Test data - these values may be changed in actual tests 
	
		int[][] arrD = {{0,1,0,0}};
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(arrD[0]);
		int expectedNumHamper = 1;
		Application application1 = new Application(array);
		
		int actualContentHamper = application1.getNumHamper();
		   
		ArrayList<Family> actualContentArray = application1.getFamilies();
		ArrayList<HamperNutrition> actualContentArrayHamper = application1.getHampers();
		Inventory actualContentInventory = application1.getInventory();
		
		assertEquals("Value of numHamper did not match what was expected: ", expectedNumHamper, actualContentHamper);
		assertNotNull("Application constructor did not create Family object when given a valid array people. ", actualContentArray);
		assertNotNull("Application constructor did not create HamperNutrition object when given a valid array people. ", actualContentArrayHamper);
		assertNotNull("Application constructor did not create Inventory object when given a valid array people. ", actualContentInventory);
    }
	
	//APPLICATION TEST 
	@Test
    public void testHamperNutritionMultiple() {
		//Multiple hampers are added from GUI input through addHamper method in application which adds to ArrayList<HamperNutrition> in application class
		//testing size of ArrayList<HamperNutrition>
		int[][] arrD = {{0,1,0,0}, {0,1,2,0}, {2,4,0,0}};
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(arrD[0]);
		array.add(arrD[1]);
		array.add(arrD[2]);
		int expectedNumHamper = 3;
		Application application2 = new Application(array);
		int actualContentHampersSize = application2.getHampers().size();
		LinkedList<Food> actualContentHamper = application2.getHamper(2); //Returns second hamper stored in arraylist
		
		assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualContentHampersSize);
		assertNotNull("Index 2 of HamperNutrition object in constructor not initialized properly. ", actualContentHamper);
    }
	
	//APPLICATION TEST 
	@Test
	public void testFamiliesArrayMultiple() {
		//Multiple families are added from GUI input through addHamper method in application which adds to ArrayList<Family> in application class
		//because new family is created (constructor is called within method addHamper()) when new hamper is specified
		int[][] arrD = {{0,1,0,0}, {0,1,2,0}, {2,4,0,0}};
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(arrD[0]);
		array.add(arrD[1]);
		array.add(arrD[2]);
		
		int expected = 3;
		   
		Application application2 = new Application(array);
		int actualFamilyListSize = application2.getFamilies().size();
		Family actualContentFamily = application2.getFamily(2); //Returns second hamper stored in arraylist to make sure all three were added
				
		assertEquals("Value of contents did not match what was expected: ", expected, actualFamilyListSize);
		assertNotNull("Index 3 of Families object in constructor not initialized properly. ", actualContentFamily);
    }
	
	//APPLICATION TEST 
	@Test
    public void testGetNumHampers() {
		//Adding another hamper within the same application, should return the correct updated number of hampers within the application
		int[][] arrD = {{0,1,2,0}, {2,4,0,0}};
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(arrD[0]);
		array.add(arrD[1]);
		int expectedNumHamper = 2;
		Application application2 = new Application(array);
		int actualContentNumHamper = application2.getNumHamper();

		assertEquals("Value of NumHamper did not match what was expected: ", expectedNumHamper, actualContentNumHamper);
    }
	
	//APPLICATION TEST
	@Test
    public void testGetUserInput() {
		//Successfully reads user input from GUI and adds that input to next index available on the arrayList of families
		int[] givenExpectedData = {2,1,0,1}; 
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(givenExpectedData);
		Application application3 = new Application(array);
		int[] actualContents = application3.getUserInput(0);
		assertEquals("Array of user input did not match what was expected: ", givenExpectedData, actualContents);
    }
}
