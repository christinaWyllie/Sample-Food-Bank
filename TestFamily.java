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
@version 1.3
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
		
		int idQuantityArray = [1,1,0,0];
		boolean exceptionThrown = false;
		try{
			Family family1 = new Family(array, idQuantityArray);
		}
		catch(IllegalArgumentExcpetion e){
			exceptionThrown = true;
		}
		assertFalse("Family constructor threw an exception when provided a valid input.", exceptionThrown);
	}
	
	//FAMILY TEST 	
	@Test 
	public void testFamilyConstructorInvalidInput(){
		//testing valid input of calorie table and invalid array simulating user input in constructor of Family, 
		//needs to throw an illegal argument exception
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
		
		int idQuantityArray = [1,-1,0,0];
		boolean exceptionThrown = false;
		try{
			Family family1 = new Family(array, idQuantityArray);
		}
		catch(IllegalArgumentExcpetion e){
			exceptionThrown = true;
		}
		assertTrue("Family constructor did not throw an exception when provided an invalid input.", exceptionThrown);
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
		
		int expectedGrain = (0.3*2500) + (0.2*2500);
		int expectedProtein = (0.2*2500) + (0.4*2500);
		int expectedFV = (0.4*2500) + (0.1*2500);
		int expectedOther = (0.1*2500) + (0.3*2500);
		int expectedTotalCals = 5000;
		
		int idQuantityArray = [1,1,0,0];
		Family family1 = new Family(array, idQuantityArray);
		
		Nutrition expected = new Nutrition(expectedGrain, expectedProtein, expectedFV, expectedOther, expectedTotalCals);
		Nutrition actual = family1.getTotal();
		
		assertNotNull("Total nutrition object was null.", actual);
		assertEquals("Nutrition object total did not match the expected object.", expected, actual);
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
		
		array[1][0] = 2;
		array[1][1] = 20;
		array[1][2] = 40;
		array[1][3] = 10;
		array[1][4] = 30;
		array[1][5] = 2500;
		
		int expectedGrain = (0.3*2500);
		int expectedProtein = (0.2*2500);
		int expectedFV = (0.4*2500);
		int expectedOther = (0.1*2500);
		int expectedTotalCals = 2500;
		
		int idQuantityArray = [1,0,0,0];
		Family family1 = new Family(array, idQuantityArray);
		
		Nutrition expected = new Nutrition(expectedGrain, expectedProtein, expectedFV, expectedOther, expectedTotalCals);
		Nutrition actual = family1.getTotal();
		
		assertNotNull("Total nutrition object was null.", actual);
		assertEquals("Nutrition object total did not match the expected object.", expected, actual);
	}
		
	//FAMILY TEST calculateCalories()
	//test that calculate calories returns correct values 
	@Test 
	public void testCalculateCaloriesMethodInFamily(){
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
		
		int idQuantityArray = [1,1,0,0];
		
		int expectedGrain = (0.3*2500) + (0.2*2500);
		int expectedFV = (0.2*2500) + (0.4*2500);
		int expectedProtein = (0.4*2500) + (0.1*2500);
		int expectedOther = (0.1*2500) + (0.3*2500);
		int expectedTotalCals = 5000;
		
		Family family1 = new Family(idQuantityArray, array);
		Nutrition f1n = family1.getTotal();
		assertEquals("Expected grain value did not match actual value.", expectedGrain, f1n.getGrain());
		assertEquals("Expected protein value did not match actual value.", expectedProtein, f1n.getProtein());
		assertEquals("Expected fruit and veggies value did not match actual value.", expectedFV, f1n.getFV());
		assertEquals("Expected other category value did not match actual value.", expectedOther, f1n.getOther());
		assertEquals("Expected total calorie value did not match actual value.", expectedTotalCals, f1n.getCalories());
	}
		
	//FAMILY TEST getTotal()
	//test that gettotal nuttrition object works
	@Test 
	public void testGetTotalNutritionFromFamily(){
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
		
		int expectedGrain = (0.3*2500) + (0.2*2500);
		int expectedProtein = (0.2*2500) + (0.4*2500);
		int expectedFV = (0.4*2500) + (0.1*2500);
		int expectedOther = (0.1*2500) + (0.3*2500);
		int expectedTotalCals = 5000;
		
		int idQuantityArray = [1,1,0,0];
		Family family1 = new Family(idQuantityArray, array);
		
		Nutrition expected = new Nutrition(expectedGrain, expectedProtein, expectedFV, expectedOther, expectedTotalCals);
		Nutrition actual = family1.getTotal();
		
		assertNotNull("Total nutrition object was null.", actual);
		assertEquals("Nutrition object total did not match the expected object.", expected, actual);
	}
}
