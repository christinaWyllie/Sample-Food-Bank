package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;


public class ENSF409FinalProjectTests{
	private int[][] calorieTable = {{1,0,50,0,50,2000},
					{2, 20, 30, 40, 10, 1000}, 
					{3, 50, 0, 10, 40, 500}, 
					{4, 30, 30, 30, 10, 100}};
	private Family family;
	private Hamper hamper;
	private Nutrition nutrition;
	private Inventory inventory;
	
	//APPLICATION TEST 
	@Test
    public void testApplicationConstructor() {
    //Num hampers creates default values
		//family object created and returns array list with one index inside
		//HamperNutrition object created and returns array list with one index 
		//Inventory object expected to contain all inventory
    //Array reads in as [Adult male, adult female, child under 8, child over 8]
		// Test data - these values may be changed in actual tests 
	
   int[] givenData = {0,1,0,0};
	 int expectedNumHamper = 1;
   Application application1 = new Application(givenData);
		
		int actualContentHamper = application1.getNumHampers();
		   
		ArrayList<Family> actualContentArray = application1.getFamilies();
		ArrayList<HamperNutrition> actualContentArrayHamper = application1.getHampers();
		LinkedList<Food> actualContentInventory = application1.getInventory();
		
  	assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualContentHamper);
		assertNotNull("Application constructor did not create Family object when given a valid array people. ", actualContentArray);
		assertNotNull("Application constructor did not create HamperNutrition object when given a valid array people. ". actualContentArrayHamper);
		assertNotNull("Application constructor did not create Inventory object when given a valid array people. ", actualContentInventory);
  }
	
	//APPLICATION TEST 
	@Test
    public void testHamperNutritionMultiple() {
    //Multiple hampers are added from GUI input through addHamper method in application which adds to ArrayList<HamperNutrition> in application class
		//testing size of ArrayList<HamperNutrition>
   	int[] array = {0,1,0,0};
	int[] array1 = {0,1,2,0};
   	int[] array2 = {2,4,0,0};
 	int expectedNumHamper = 3;
	Application application2 = new Application(array);
  	application2.addHamper(array1);
	application2.addHamper(array2);
	int actualContentHampersSize = application2.getHampers().size();
	LinkedList[] actualContentHamper = application2.getHamper(2); //Returns second hamper stored in arraylist
	
   	 assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualContentHampersSize);
	assertNotNull("Index 2 of HamperNutrition object in constructor not initialized properly. ", actualContentHamper);
    }
	
	//APPLICATION TEST 
	@Test
    public void testFamiliesArrayMultiple() {
    //Multiple families are added from GUI input through addHamper method in application which adds to ArrayList<Family> in application class
		//because new family is created (constructor is called within method addHamper()) when new hamper is specified
    int[] array = {0,1,0,0};
		int[] array1 = {0,1,2,0};
    int[] array2 = {2,4,0,0};
		int expected = 3;
       
		Application application2 = new Application(array);
    application2.addHamper(array1);
		application2.addHamper(array2);
    int actualFamilyListSize = application2.getHampers().size();
    Family actualContentFamily = application2.getfamily(2); //Returns second hamper stored in arraylist to make sure all three were added
			
    assertEquals("Value of contents did not match what was expected: ", expected, actualFamilyListSize);
		assertNotNull("Index 3 of Families object in constructor not initialized properly. ", actualContentFamily);
    }
	
	//APPLICATION TEST 
	@Test
    public void testGetNumHampers() {
    //Adding another hamper within the same application, should return the correct updated number of hampers within the application
		int[] array1 = {0,1,2,0};
    int[] array = {2,4,0,0};
    int expectedNumHamper = 2;
		Application application2 = new Application(array1);
    application2.addHamper(array);
		int actualContentNumHamper = application2.getNumHampers();

     assertEquals("Value of NumHamper did not match what was expected: ", expectedNumHamper, actualContentNumHampers);
    }
	
	//APPLICATION TEST
	@Test
    public void testGetUserInput() {
    //Successfully reads user input from GUI and adds that input to next index available on the arrayList of families
		int[] givenExpectedData = {2,1,0,1};    
    Application application3 = new Application(array);
		int[] actualContents = application3.getUserInput(0);
		
    assertEquals("Array of user input did not match what was expected: ", givenExpectedData, actualContents);
    }
		
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
	//ORDERFORM TEST 
	@Test
	public void testOrderFormConstructor() {
		
	createFoodHamperFamilyObjects();
	OrderForm form = new OrderForm(family, inventory, hamper);
	assertNotNull("Order form did not create a valid object", form);
	}
	
	
	@Test
	public void testIOException(){
	// testing that print() method in OrderForm throws an exception when it cannot write to the txt file.
	OrderForm order = new OrderForm(family, inventory, hamper);
	boolean exceptionThrown = false;
        try {
            order.print();
        }
        catch (Exception e) {
            exceptionThrown = true;
        }

        assertFalse("Error thrown from print", exceptionThrown);
    }
	
	
	@Test
	public void testPrint(){
	// test the printing of an order form to an output txt file.
	createFoodHamperFamilyObjects();
	OrderForm order = new OrderForm(family, inventory, hamper);
		
	String expectedOutput = "Name:" +
				"Date:" +
		
				"Original Request" +
				"Hamper 1: 1 Adult Female"+

				"Hamper 1 Items: " +
				"1		Wheat Bread, loaf" +
				"5		Orange, dozen" +
				"6		Eggs, dozen";
		
	try{
		File file = new File("somefile.txt");	
		FileWriter writer = new FileWriter(file)
		writer.append(expectedOutput);
	}
	catch(IOException e){
		System.out.println("Test failed, could not create file");
	}
		order.print();
		
	boolean equal = isEqual(file,"OrderForm.txt"); //the file will be created in order form with the name OrderForm
	assertTrue("Error, unexpected output writen to the file", equal)
	}
	
	 public void testOrderFormImplementsFormatString(){
	//tests that the OrderForm class implements the FormatString interface
		createFoodHamperFamilyObjects();
		OrderForm order = new OrderForm(family, inventory, hamper);
		assertTrue("Order Form does not implement FormatOutput", (FormatOutput.class.isAssignableFrom(order.getClass()));
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
	//INVENTORY TEST 
  	 @Test
  	 public void testInventoryConstructorWithInvalidDataBase(){
	//testing inventory with no database
	   Inventory inv = new Inventory();
	   assertNull("Inventory object with invalid database connection was not null", inv);
	}
	
	//INVENTORY TEST
	@Test
	public void testInventorySetters(){
	//tests the set methods for inventory, setCalories and setInventory
		Inventory inventory = new Inventory();
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
		inventory.setCalories(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		inventory.setInventory(list);
		
		LinkedList<Food> removallist= new LinkedList<Food>();
		removallist.add(food10);
		removallist.add(food11);
		inventory.setRemoveInventory(removallist);
		
		assertEquals("Inventory inventory list does not match expected.", inventory.getInventory(), list);
		assertEquals("Inventory calorie table does not match expected.", inventory.getCalorieTable(), array);
		assertEquals("Inventory removed inventory list does not match expected.", inventory.getRemovedInventory(), removallist);
	}
	//INVENTORY TEST 
	@Test
	public void testInventoryRemoval(){
	//tests that the removemethod from invenotry correctly removes from the main inventory linked list
		Inventory inventory = new Inventory();
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
		inventory.setCalories(array);
		
		Food food10 = new Food(10, "Eggs, dozen", 0, 0, 50, 50, 1000);
		Food food11 = new Food(11, "Oranges, dozen", 0, 0, 9, 91, 100);
		Food food12 = new Food(12, "Granola Bars", 8, 0, 2, 90, 500);
		Food food13 = new Food(13, "Carrots", 10, 30, 40, 20, 200);
		
		LinkedList<Food> list= new LinkedList<Food>();
		list.add(food10);
		list.add(food11);
		list.add(food12);
		list.add(food13);
		inventory.setInventory(list);
		
		LinkedList<Food> remove= new LinkedList<Food>();
		remove.add(food10);
		remove.add(food11);
		list.remove(0);
		list.remove(1);
		inventory.setRemoveInventory(remove);
		inventory.removeInventory();
		
		LinkedList<Food> actualRemoved = inventory.getRemovedInventory();
		LinkedList<Food> actualInv = inventory.getInventory();
		assertEquals("Inventory removed inventory list does not match expected.", actualRemoved, remove);
		assertEquals("Inventory inventory list does not match expected.", actualInv, list);
	}
			   
	//INVENTORY TEST
	@Test
	public void testRemoveDataBase(){
	//testing remove from datatbase method assuming valid database
	Inventory inventory = new Inventory();
	String name1= "Wheat bread, loaf";
	int id = 1;
	int g1 = 96;
	int f1 = 0;
	int p1 = 4;
	int o1 = 0;
	int c1 = 2192;
	Food food1 = Food(id, name1, g1, f1, p1, o1, c1); //assuming this a valid entry in database
	LinkedList<Food> remove= new LinkedList<Food>();
	remove.add(food1);
	inventory.setRemoveInventory(remove);
	inventory.removeInventory();
		
	boolean status = inventory.removeDataBase();
	assertTrue("Inventory item was not removed from database.", status);
	}
	
	//HAMPERNUTRITION TEST 
	@Test
	public void HamperNutritionImplementsCalculate(){
	//Tests for Hamper Nutrition
	HamperNutrition hamp = new HamperNutrition();
	assertTrue("HamperNutrition does not implement Calculate", (Calculate.class.isAssignableFrom(hamp.getClass())));
	}
			   
	//HAMPERNUTRITION TEST 
	@Test
	public void testCheckInventoryNotEnoughInventory()
	//tests that the NotEnoughInventoryExcpetion was thrown when there has not enough/any inventory avialable
	{
	boolean correctException = false;
	 try
	   {
		int g = 12;
		int p = 13;
		int f = 14;
		int o = 7;
		int c = 340;
		
		Nutrition n = new Nutrition(g, p, f, o, c);
		HamperNutrition hamp = new HamperNutrition(n);
		hamp.checkInventory();
		}
	catch(NotEnoughInventoryException e)
	{
		correctException = true;
	}
	assertTrue("NotEnoughInventory excpetion was not thrown when there is not enough inventory to create a hamper.", correctException);
}
	//HAMPERNUTRION TEST 
	@Test //FIX 
	public void testHamperNutritionConstructor() 
	{      
	int g = 12;
	int p = 13;
	int f = 14;
	int o = 7;
	int c = 340;
		
	Nutrition n = new Nutrition(g, p, f, o, c);
	HamperNutrition hamp = new HamperNutrition(n);
	
    	assertNotNull("HamperNutrition constructor did not create an object when given a nutrition object", hamp);
	//Initialize hamper linked list in constructor and should be null;
	assertNull("Hamper LinkedList was not null: ", hamp.getHamper());
	}
			   
	//HAMPERNUTRITION TEST
	@Test
	public void testHamperGetterAndSetters()
	{
	//Tests getHamper, addToHamper with one food item
	
	LinkedList<Food> expectedHamper = new LinkedList<Food>();
	Food f = new Food(10, 10, 10, 10, 10, 87, "Broccoli");
	expectedHamper.add(f);
	
	int g = 12;
	int p = 13;
	int f = 14;
	int o = 7;
	int c = 340;
		
	Nutrition n = new Nutrition(g, p, f, o, c);
	HamperNutrition hamp = new HamperNutrition(n);
	hamp.addToHamper(f);
	LinkedList<Food> hamper = hamp.getHamper();
	assertEquals("Method getHamper did not return the expected hamper: ", expectedHamper, hamp)
}
		
	 /* ******************* HELPER METHODS ***************** */

    /*
    * Create a test file to read in (in working directory)
    */
    private void createFoodHamperFamilyObjects() {
       //create food objects 
	   	   
	   String name1= "Wheat bread, loaf";
	   int id1 = 1;
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = Food(id1, name1, g1, f1, p1, o1, c1);
	   
	   String name2 = "Wheat bread, loaf";
	   int id2 = 2;
	   int g2 = 96;
	   int f2 = 0;
	   int p2 = 4;
	   int o2 = 0;
	   int c2 = 2192;
	   Food food1 = new Food(id2, name2, g2, f2, p2 o2, c2);
	   
	   String name3= "Wheat bread, loaf";
	   int id3 = 3;
	   int g3 = 96;
	   int f3 = 0;
	   int p3 = 4;
	   int o3 = 0;
	   int c3 = 2192;
	   Food food2 = new Food(id3, name3, g3, f3, p3, o3, c3);

	   String name4= "Orange, dozen";
	   int id4 = 4;
	   int g4 = 0;
	   int f4 = 100;
	   int p4 = 0;
	   int o4 = 0;
	   int c4 = 864;
	   Food food4 = new Food(id4, name4, g4, f4, p4, o4, c4);
	   
	   String name5= "Orange, dozen";
	   int id5 = 5;
	   int g5 = 0;
	   int f5 = 100;
	   int p5 = 0;
	   int o5 = 0;
	   int c5 = 864;
	   Food food5 = new Food(id5, name5, g5, f5, p5, o5, c5);
	   
	   String name6 = "Eggs, dozen";
	   int id6 = 6;
	   int g6 = 0;
	   int f6 = 0;
	   int p6 = 9;
	   int o6 = 91;
	   int c6 = 864;
	   Food food6 = new Food(id6, name6, g6, f6, p6, o6, c6);
	   
	   LinkedList<Food> foodList = new LinkedList<Food>(); 
	   foodList.add(food1);
	   foodList.add(food2);
	   foodList.add(food3);
	   foodList.add(food4);
	   foodList.add(food5);
	   foodList.add(food6);
	   
	   int[][] array = new int[4][6];
		
	   array[1][0] = 2;
	   array[1][1] = 16;
	   array[1][2] = 28;
	   array[1][3] = 26;
	   array[1][4] = 30;
	   array[1][5] = 2500;
		
	   Inventory inventory = new Inventory();
	   inventory.setInventory(foodList);
      	   inventory.setCalories(array);
		
	   int[] id = {0,1,0,0};
		
	   Family family = new Family(id, array);
		
	   ArrayList familyList = new ArrayList<Family>();
	   familyList.add(family);
		
	   Nutrition nutrition = new Nutrition(g6, p6, f6, o6, c6);
		
	   HamperNutrition hamper = new HamperNutrition(nutrition);
    }
			   
			   
			   
			   
			   
			   
}
