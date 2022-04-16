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

/*
							!!!!!!READ ME FIRST!!!!!!!


Application utilizes the entire program meaning it requires all classes to work along with the DataBase
	- Because of this, DataBase .sql file must be reset after every run of the TestApplication
	- Values of user input are important to consider as adding too many members to a family as part of one application could cause 
		Exceptions to be thrown since the database will NOT be reset after every application call
	- We have chosen to implement the code as such because realistically applications will not have a new DataBase to work with and subequent applications will have a different 
		(and smaller) versions of the database since food items will probably not be replaced after a call
	

	****This means changing the values of the original user input MAY cause these tests to fail depending on the size of the database that we are testing
	**** AND the nutritional values of each family
	
	- Tests are heavily reliant on what the intitial database that we are testing with looks like
	
	NOTE: Why there will never be invalid user input - 
		- The GUI has been implemented in such a way that application will only ever recieve vaild user input 
		- GUI checks for negative integers, non numeric characters AND when user has submitted a hamper with all 0 inputs 
			- GUI will display a message that informs user their input is invalid and prompts to try again before finally submitting their application 
*/


public class TestApplication{
	private static Application app1 = null;
	private static Application app2 = null;
	
	@BeforeClass
	public static void createApplication() {
		//DataBase calls can be taxing and fail if too many family units are created (see disclaimer above) 
		//Because of this, these tests will create input before and test the values of these pre created applications rather than creating a new application
		
		
		int[][] arrD = {{0,1,0,0}, {1,2,1,0}}; //Fake user input 
		ArrayList<int[]> array1 = new ArrayList<int[]>();
		array1.add(arrD[0]); //Test with just one member (default) 
		
		ArrayList<int[]> array2 = new ArrayList<int[]>();
		array2.add(arrD[0]); //Test when multiple hampers are called and need to be created 
		array2.add(arrD[1]);
		
		try{ //These applications will not throw any exceptions and will successfully pass the tests 
			app2 = new Application(array2); 
			app1 = new Application(array1);
		}
		
		catch(NotEnoughInventoryException e) {
			e.printStackTrace();
		}
		catch(RemoveFromDataBaseFailedException e) {
			e.printStackTrace();
		}
	
	}
	
	//APPLICATION TEST 
	
	@Test
    public void testApplicationConstructor() {
    //Num hampers creates default values
	//family object created and returns array list with one index inside
	//HamperNutrition object created and returns array list with one index 
	//Inventory object expected to contain all inventory
	//Array reads in as [Adult male, adult female, child under 8, child over 8]
	// Test data - these values may be changed in actual tests 
	
		int expectedNumHamper = 1;

		Application application1 = app1;
		ArrayList<Family> actualContentArray = application1.getFamilies();
		ArrayList<HamperNutrition> actualContentArrayHamper = application1.getHampers();
		Inventory actualContentInventory = application1.getInventory();
		int actualContentHamper = application1.getNumHamper();
			
			
		assertEquals("Value of numHamper did not match what was expected: ", expectedNumHamper, actualContentHamper);
		assertNotNull("Application constructor did not create Family object when given a valid array people. ", actualContentArray);
		assertNotNull("Application constructor did not create HamperNutrition object when given a valid array people. ", actualContentArrayHamper);
		assertNotNull("Application constructor did not create Inventory object when given a valid array people. ", actualContentInventory);
    }
	
	//APPLICATION TEST 
	@Test
    public void testHamperNutritionAndFamilyNutritionWithMultipleHampers() {
		//Multiple hampers are added from GUI input through application constructor which adds to ArrayList<HamperNutrition> in application class
		//testing size of ArrayList<HamperNutrition>
		//Multiple families are added from GUI input through application constructor which adds to ArrayList<Family> in application class
		//testing size of ArrayList<Family> which should be the same size as numHampers and ArrayList<HamperNutrition>
		
		int expectedNumHamper = 2;
		Application application2 = app2;
		int actualContentHampersSize = application2.getHampers().size();
		LinkedList<Food> actualContentHamper = application2.getHamper(1); //Returns second hamper stored in arraylist
		
		int actualFamilyListSize = application2.getFamilies().size();
		Family actualContentFamily = application2.getFamily(0); //Returns second hamper stored in arraylist to make sure all three were added
			
		assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualContentHampersSize);
		assertNotNull("Index 2 of HamperNutrition object in constructor not initialized properly. ", actualContentHamper);
		
		assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualFamilyListSize);
		assertNotNull("Index 3 of Families object in constructor not initialized properly. ", actualContentFamily);
    } 

	//APPLICATION TEST 
	@Test
    public void testGetNumHampers() {
		//Adding another hamper within the same application, should return the correct updated number of hampers within the application
		
		Application application2 = app2;
		int actualContentNumHamper = application2.getNumHamper();
		assertEquals("Value of NumHamper did not match what was expected: ", 2, actualContentNumHamper);
    }
	
	//APPLICATION TEST
	@Test
    public void testGetUserInput() {
		//Successfully reads user input from GUI and adds that input to next index available on the arrayList of families
		int[] givenExpectedData = {0,1,0,0};
		Application application2 = app2;
		int[] actualContents = application2.getUserInput(0);
		assertEquals("Array of user input did not match what was expected: ", givenExpectedData[1], actualContents[1]);
    }
	
	
	@Test
	public void testNotEnoughInventoryException() {
		int[] givenData = {17,2,7,25}; //Will obviously be too large of a family unit for there to be enough inventory 
		ArrayList<int[]> array = new ArrayList<int[]>();
		array.add(givenData); //Test with just one member (default) 
		boolean exception = false;
		
		try{
			Application fails = new Application(array);
		}
		
		catch(NotEnoughInventoryException e) {
			exception = true;	
		}
		catch(RemoveFromDataBaseFailedException e) {
			exception = false; 
		}		 

		assertTrue("NotEnoughInventoryException was not thrown from application when it should have been.", exception);
	}
	
	/*RemoveFromDataBaseFailedException not tested as it is thrown in OrderForm and is an exception that has to do more with DataBase than user input causing it to be thrown
		- Because Application also does not have an OrderForm object there is no way to access it
		- Application as stated before does a full run through of the program there is no way to cause an interruption during orderForm
		- It is likely that NotEnoughInventoryException will be thrown before DataBase can even be accesssed, this is because of user input containing too many indivuals 
	*/
}
	
