package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;


public class FinalProjectTest {
	 
//TEST APPLICATION
	@Test
    public void testApplicationConstructor() {
        //Num hampers create default values
		//family object created and returns array list 
        //Array reads in as [Adult male, adult female, child under 8, child over 8]
		
		// Test data - these values may be changed in actual tests 
        int givenData = [0,1,0,0];
		int expectedNumHamper = 1;
        Application application1 = new Application(givenData);
		
		int actualContentHamper = application1.getNumHampers();
		ArrayList<Family> expectedArray = new ArrayList<Family>();
		expectedArray.add(new Family(givenData)); 
		ArrayList<Family> actualContentArray = application1.getFamilies();
		
        assertEquals("Value of contents did not match what was expected: ", expectedNumHamper, actualContentHamper);
		assertEquals("Value of contents did not match what was expected: ", expectedArray, actualContent);
    }

	@Test
    public void testGetAddHamper() {
        //Adding a family to the arraylist which creates a new family object within the same application 
		int array1 = [0,1,2,0]
        int array = [2,4,0,0];
        int expectedNumHamper = 2
		Application application2 = new Application(array1);
        application2.addHamper(array);
		int actualContentNumHamper = application2.getNumHampers();

        assertEquals("Value of NumHamper did not match what was expected: ", expectedNumHamper, actualContentNumHampers);
    }
	
	@Test
    public void testGetUserInput() {
        //Successfully reads user input and arraylist adds that input to next index available
       
	    int givenData = [2,1,0,1];
        String expected = "Your family unit contains: 2 Adult Male, Adult Female, 0 Child under 8, 1 Child Over 8";
        
        Application application3 = new Application(array);
		int actualContents = application3.getUserInput();

        assertEquals("String did not match what was expected: ", expected, actualContents);
    }
	
	//TEST FAMILY
	
	@Test
    public void testFamilyConstructorDefault() {
        int array = [1,0,1,0];
     
        String expected = "0230";
        Family family1 = new Family(array);
		String actualContent = family1.getID();

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	@Test
    public void testMultipleFamily() {
        //Arraylist
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	@Test
    public void testGetTotalNutrition() {
        
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
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
		Application application2 = new Application(array);
		
		int actualContentGrain = application2.getGrain();
        int actualContentProtein = application2.getProtein();
		int actualContentFV = application2.getFV();
		int actualContentOther = application2.getOther();
		int actualContentCalories = application2.getCalories();
        

        assertEquals("Value of grains did not match what was expected: ", givenData, actualContents);
		assertEquals("Value of protien did not match what was expected: ", givenData, actualContents);
		assertEquals("Value of FV content did not match what was expected: ", givenData, actualContents);
		assertEquals("Value of other nutrition did not match what was expected: ", givenData, actualContents);
		assertEquals("Value of calories did not match what was expected: ", givenData, actualContents);
    }
	
	//NUTRITION TESTS
	@Test
    public void testNutritionCalculate() {
        //Nutrition when given a full family (checks total caloric requirements)
        int givenDataGrain = 400 + 320 + ;
        int givenDataFV = 700 + 560;
		int givenDataProtein = 650 + 520;
		int givenDataOther = 750 + 600 ;
		int givenDataCalories = 8100;
		
		int[] array = [1,1,1,1];
		Application application2 = new Application(array);
		
		int actualContentGrain = application2.getGrain();
        int actualContentProtein = application2.getProtein();
		int actualContentFV = application2.getFV();
		int actualContentOther = application2.getOther();
		int actualContentCalories = application2.getCalories();
        

        assertEquals("Value of grains did not match what was expected: ", givenDataGrain, actualContentGrain);
		assertEquals("Value of protien did not match what was expected: ", givenDataProtien, actualContentProtien);
		assertEquals("Value of FV content did not match what was expected: ", givenDataFV, actualContentFV);
		assertEquals("Value of other nutrition did not match what was expected: ", givenDataOther, actualContentOther);
		assertEquals("Value of calories did not match what was expected: ", givenDataCalories, actualContentCalories);
    }
	
	
	
	
	//EXCEPTION TESTS
	@Test
   public void testNotEnoughInventoryException() {
        //Individual nutitrion values returned for each available index for family array list
		
		
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	
	@Test
   public void testIllegalArugementException() {
        //Individual nutitrion values returned for each available index for family array list
		
		
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
		@Test
   public void testIOException() {
        //Individual nutitrion values returned for each available index for family array list
		
		
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	//HAMPERNUTRITION TESTS
	
		@Test
   public void test() {
        //Individual nutitrion values returned for each available index for family array list
		
		
        // Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	//ORDERFORM TESTS
	
	
		@Test
   public void testRemoveInventory() {
        //testing the removal of items from food, parallel to the database
	   
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
	   
	   

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	//test OrderForm constructor which uses 
	public void testOrderFormConstructor() {
		
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
	   
		
		Inventory inventory = new Inventory();
		inventory.setInventory(foodList);
		
		int[] id = {0,1,0,0};
		int[][] array = new int[4][6];
		
		array[1][0] = 2;
		array[1][1] = 16;
		array[1][2] = 28;
		array[1][3] = 26;
		array[1][4] = 30;
		array[1][5] = 2500;
		
		Family family = new Family(id, array);
		
		ArrayList familyList = new ArrayList<Family>();
		familyList.add(family);
	}

//FOOD CLASS TEST CONSTRUCTOR
	@Test
	public void testFoodConstructorandGetter(){
		
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
   
   //TEST FOOD CONSTRUCTOR WITH VALID INPUT
   public void testFoodConstructorWithValidInput(){
	   boolean exceptionThrown = false;
	   String name1= "Wheat bread, loaf";
	   int id = 12;
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   try{
		Food food1 = Food(name1, g1, f1, p1, o1, c1);
		}
		catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
	   assertFalse("Illegal Argument Exception thrown with valid constructor input.", exceptionThrown);
   }
	   
   
   //TEST FOOD CONSTRUCTOR WITH INVALID INPUT
   public void testFoodConstructorWithInvalidInput(){
	   boolean exceptionThrown = false;
	   String name1= "Wheat bread, loaf";
	   //id not provided
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   try{
		Food food1 = Food(name1, g1, f1, p1, o1, c1);
		}
		catch(IllegalArgumentException e){
			exceptionThrown = true;
		}
	   assertTrue("Illegal Argument not thrown with invalid constructor input.", exceptionThrown);
   }
	   
   }
   //test food and nutrition 
   @Test
   public void testFoodGetters(){
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
   
   //DATABASE CONSTRUCTOR
   //testing with invalid data, no database
   @Test
   public void testDataBaseConstructorWithInvalidDataBase(){
	   boolean exceptionThrown = false;
	   try{
			DataBase data = new DataBase();
		}
		catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse("DataBase threw an exception when it should not have.", exceptionThrown);
	}
	//DATABASE CONSTRUCTOR
	//testing with valid data, database is valid
   @Test
   public void testDataBaseConstructorWithValidDataBase(){
	   boolean exceptionThrown = false;
	   try{
			DataBase data = new DataBase();
		}
		catch(Exception e){
			exceptionThrown = true;
		}
		assertFalse("DataBase threw an exception even when valid database was provided.", exceptionThrown);
	}
	//TESTING INVENTORY 
	//testing inventory with no database
   @Test
   public void testInventoryConstructorWithInvalidDataBase(){
	   Inventory inv = new Inventory();
	   
		assertNull("Inventory object with invalid database connection was not null", inv);
	}
	//TESTING INVENTORY SETTERS
	@Test
	public void testInventorySetters(){
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
		assertEquals("Inventory inventory list does not match expected.", inventory.getInventory(), list);
		assertEquals("Inventory calorie table does not match expected.", inventory.getCalorieTable(), array);
	}
	//TESTING INVENTORY TO BE REMOVED
	//tests removeFromInventory
	@Test
	public void testInventoryRemoval(){
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
		inventory.removeFromInventory(remove);
		
		LinkedList<Food> actualRemoved = inventory.getRemovedInventory();
		LinkedList<Food> actualInv = inventory.getInventory();
		assertEquals("Inventory removed inventory list does not match expected.", actualRemoved, remove);
		assertEquals("Inventory inventory list does not match expected.", actualInv, list);
	}
	//TESTING REMOVE FROM THE DATABASE
	//assuming valid database
	@Test
	public void testRemoveDataBase(){
		Inventory inventory = new Inventory();
		String name1= "Wheat bread, loaf";
		int id = 1;
	    int g1 = 96;
	    int f1 = 0;
	    int p1 = 4;
	    int o1 = 0;
	    int c1 = 2192;
	    Food food1 = Food(id, name1, g1, f1, p1, o1, c1); //assuming this a valid entry in database
		assertEquals("Inventory removed inventory list does not match expected.", actualRemoved, remove);
		assertEquals("Inventory inventory list does not match expected.", actualInv, list);
	}
	
}
