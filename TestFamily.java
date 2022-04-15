/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestFamily.java
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

public class TestFamily{
	//TESTING FAMILY 
	
	@Test 
	public void testFamilyConstructorValidInput(){
		//testing valid input of calorie table and array simulating user input in constructor of Family
		int[][] array = new int[4][6];
		array[0][0] = 1;
		array[0][1] = 16;
		array[0][2] = 28;
		array[0][3] = 30;
		array[0][4] = 26;
		array[0][5] = 2500;
		
		array[1][0] = 2;
		array[1][1] = 16;
		array[1][2] = 28;
		array[1][3] = 26;
		array[1][4] = 30;
		array[1][5] = 2500;
		// set the id array to one adult male and one adult female
		int[] idQuantityArray = {1,1,0,0};
		boolean exceptionThrown = false;
		try{
			Family family1 = new Family(idQuantityArray, array);
		}
		catch(IllegalArgumentException e){
			exceptionThrown = true; 
		}
		assertFalse("Family constructor threw an exception when provided a valid input.", exceptionThrown);
		//assert that no exception was thrown when provided valid input
	}
	
	

	
	//FAMILY TEST
	@Test
	public void testGetTotalNutritionFromFamilyMultipleMembers(){
		//test that gettotal nuttrition object returns the expected values for total number of calories for multiple people
		int[][] array = new int[4][6];
		array[0][0] = 1;
		array[0][1] = 30;
		array[0][2] = 20;
		array[0][3] = 40;
		array[0][4] = 10;
		array[0][5] = 2500;
		
		array[1][0] = 2;
		array[1][1] = 20;
		array[1][2] = 40;
		array[1][3] = 10;
		array[1][4] = 30;
		array[1][5] = 2500;
		
		//calculate the total for each category by dividing the percentage by 100 then multiply by the calories needed
		// add each individual category for each person up and multiply by 7 for the total for a week
		int expectedGrain = (int)(((array[0][1]/100.0)* array[0][5]) + ((array[1][1]/100.0)*array[1][5]))*7;
		int expectedProtein = (int)(((array[0][3]/100.0)*array[0][5]) + ((array[1][3]/100.0)*array[1][5]))*7;
		int expectedFV = (int)(((array[0][2]/100.0)*array[0][5]) + ((array[1][2]/100.0)*array[1][5]))*7;
		int expectedOther = (int)(((array[0][4]/100.0)*array[0][5]) + ((array[1][4]/100.0)*array[1][5]))*7;
		int expectedTotalCals = ( array[0][5] + array[1][5] ) * 7;
	
		int[] idQuantityArray = {1,1,0,0};
		Family family1 = new Family(idQuantityArray, array);
		
		Nutrition expected = new Nutrition(expectedGrain, expectedFV, expectedProtein, expectedOther, expectedTotalCals);
		int actualG = family1.getTotal().getGrain();
		int actualF = family1.getTotal().getFV();
		int actualP = family1.getTotal().getProtein();
		int actualO = family1.getTotal().getOther();
		int actualC = family1.getTotal().getCalories();
		
		Nutrition actual = family1.getTotal();
		assertNotNull("Total nutrition object was null.", actual);
		assertEquals("Nutrition grain object total did not match the expected object.", expectedGrain, actualG);
		assertEquals("Nutrition FV object total did not match the expected object.", expectedFV, actualF);
		assertEquals("Nutrition protein object total did not match the expected object.", expectedProtein, actualP);
		assertEquals("Nutrition other object total did not match the expected object.", expectedOther, actualO);
		assertEquals("Nutrition calories object total did not match the expected object.", expectedTotalCals, actualC);
	}
	
	//FAMILY TEST
	@Test
	public void testGetTotalNutritionFromFamilySingleMember(){
		//test that gettotal nuttrition object returns the expected values for total number of calories for 1 family member
		int[][] array = new int[4][6];
		array[0][0] = 1;
		array[0][1] = 30;
		array[0][2] = 20;
		array[0][3] = 40;
		array[0][4] = 10;
		array[0][5] = 2500;
		
		//calculating the expceted values based on the array 
		int expectedGrain = (int)(((array[0][1]/100.0)* array[0][5]))*7;
		int expectedProtein = (int)(((array[0][3]/100.0)*array[0][5]) )*7;
		int expectedFV = (int)(((array[0][2]/100.0)*array[0][5]))*7;
		int expectedOther = (int)(((array[0][4]/100.0)*array[0][5]) )*7;
		int expectedTotalCals = ( array[0][5]  ) * 7;
	
		
		int[] idQuantityArray = {1,0,0,0};
		Family family1 = new Family(idQuantityArray, array);
		
		//retrieve the actual values the code produces
		Nutrition expected = new Nutrition(expectedGrain, expectedFV, expectedProtein, expectedOther, expectedTotalCals);
		int actualG = family1.getTotal().getGrain();
		int actualF = family1.getTotal().getFV();
		int actualP = family1.getTotal().getProtein();
		int actualO = family1.getTotal().getOther();
		int actualC = family1.getTotal().getCalories();
		
		Nutrition actual = family1.getTotal();
		//assert each individual value matches the manually calculated values.
		assertNotNull("Total nutrition object was null.", actual);
		assertEquals("Nutrition grain object total did not match the expected object.", expectedGrain, actualG);
		assertEquals("Nutrition FV object total did not match the expected object.", expectedFV, actualF);
		assertEquals("Nutrition protein object total did not match the expected object.", expectedProtein, actualP);
		assertEquals("Nutrition other object total did not match the expected object.", expectedOther, actualO);
		assertEquals("Nutrition calories object total did not match the expected object.", expectedTotalCals, actualC);
	}
	
	
	@Test
	public void testGetID(){
		// test that the correct ID is returned for each person
		int[][] array = new int[4][6];
		//populate the array for an adult male
		array[0][0] = 1;
		array[0][1] = 30;
		array[0][2] = 20;
		array[0][3] = 40;
		array[0][4] = 10;
		array[0][5] = 2500;
		
		//populate the array for an adult female
		array[1][0] = 2;
		array[1][1] = 20;
		array[1][2] = 40;
		array[1][3] = 10;
		array[1][4] = 30;
		array[1][5] = 2500;
		
		//populate the child over 8 array
		array[2][0] = 3;
		array[2][1] = 21;
		array[2][2] = 33;
		array[2][3] = 31;
		array[2][4] = 15;
		array[2][5] = 2200;
		
		//populate the child over 8 array
		array[2][0] = 4;
		array[2][1] = 21;
		array[2][2] = 33;
		array[2][3] = 31;
		array[2][4] = 15;
		array[2][5] = 1400;
	
		
		int[] idQuantityArray = {1,2,1,1};
		Family family1 = new Family(idQuantityArray, array);
		
		//using the getIDAtIndex() method, get the string equivalent for each index
		String male = family1.getIDAtIndex(0);
		String female = family1.getIDAtIndex(1);
		String childO8 = family1.getIDAtIndex(2);
		String childU8 = family1.getIDAtIndex(3);
		
		// the expected strings
		String expectedMale = "1 Adult Male";
		String expectedFemale = "2 Adult Female";
		String expectedChildU8 = "1 Child under 8";
		String expectedChildO8 = "1 Child over 8";
		
		assertEquals("Unexpected string returned from getID for male", expectedMale, male);
		assertEquals("Unexpected string returned from getID for female", expectedFemale, female);
		assertEquals("Unexpected string returned from getID for child over 8", expectedChildO8, childO8);
		assertEquals("Unexpected string returned from getID for child under 8", expectedChildU8, childU8);
		
	}
	
	@Test
	public void testGetNutrition(){
		int[][] array = new int[4][6];
		//populate the array for an adult male
		array[0][0] = 1;
		array[0][1] = 30;
		array[0][2] = 20;
		array[0][3] = 40;
		array[0][4] = 10;
		array[0][5] = 2500;
		
		//populate the array for an adult female
		array[1][0] = 2;
		array[1][1] = 20;
		array[1][2] = 40;
		array[1][3] = 10;
		array[1][4] = 30;
		array[1][5] = 2500;
		
		//populate the child over 8 array
		array[2][0] = 3;
		array[2][1] = 21;
		array[2][2] = 33;
		array[2][3] = 31;
		array[2][4] = 15;
		array[2][5] = 2200;
		
		//populate the child over 8 array
		array[3][0] = 4;
		array[3][1] = 21;
		array[3][2] = 33;
		array[3][3] = 31;
		array[3][4] = 15;
		array[3][5] = 1400;
		
		int[] idQuantityArray = {1,1,0,1};
		Family family1 = new Family(idQuantityArray, array);
		
		// add together the percentage divded by 100 multiplied by the amount of calories that person needs and the amount of people in that category
		// then multiply the total by 7 to get the total of each group for one week
		int totalG = (int)(((array[0][1]/100.0)* array[0][5]* idQuantityArray[0]) + ((array[1][1]/100.0)*array[1][5]* idQuantityArray[1])
				+ ((array[2][1]/100.0)*array[2][5]* idQuantityArray[2]) + ((array[3][1]/100.0)*array[3][5]* idQuantityArray[3]))*7;
		int totalP = (int)(((array[0][3]/100.0)*array[0][5]* idQuantityArray[0]) + ((array[1][3]/100.0)*array[1][5]* idQuantityArray[1])
				+ ((array[2][3]/100.0)*array[2][5]* idQuantityArray[2]) + ((array[3][3]/100.0)*array[3][5]* idQuantityArray[3]))*7;
		int totalF = (int)(((array[0][2]/100.0)*array[0][5]* idQuantityArray[0]) + ((array[1][2]/100.0)*array[1][5]* idQuantityArray[1]) 
				+ ((array[2][2]/100.0)*array[2][5]* idQuantityArray[2]) + ((array[3][2]/100.0)*array[3][5]* idQuantityArray[3]))*7;
		int totalO = (int)(((array[0][4]/100.0)*array[0][5]* idQuantityArray[0]) + ((array[1][4]/100.0)*array[1][5]* idQuantityArray[1]) 
				+ ((array[2][4]/100.0)*array[2][5]* idQuantityArray[2]) + ((array[3][4]/100.0)*array[3][5]* idQuantityArray[3]))*7;
		int totalC = ( array[0][5]* idQuantityArray[0] + array[1][5]* idQuantityArray[1]
				+ array[2][5]* idQuantityArray[2] + array[3][5]* idQuantityArray[3]) * 7;
		
		int actualG = family1.getTotal().getGrain();
		int actualF = family1.getTotal().getFV();
		int actualP = family1.getTotal().getProtein();
		int actualO = family1.getTotal().getOther();
		int actualC = family1.getTotal().getCalories();
		
		// check that each object mathces the expected based on the manual calculations
		assertEquals("Unexpected value for total grain", totalG, actualG);
		assertEquals("Unexpected value for total other", totalO, actualO);
		assertEquals("Unexpected value for total fruits and veggies", totalF, actualF);
		assertEquals("Unexpected value for total protein", totalP, actualP);
		assertEquals("Unexpected value for total calories", totalC, actualC);
		
	}
}
