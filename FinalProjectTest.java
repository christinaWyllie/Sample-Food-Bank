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
		//client object created 
        
		
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
    public void testTerminateApplication() {
        
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
    public void testSetGetNumHampers() {
        //Adding a family to the arraylist which creates a new family object within the same application 
        
		
		// Test data - these values may be changed in actual tests 
        int givenData = 2;
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        application1.setHamper(givenData);
         = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	@Test
    public void testSetGetNumHampers() {
        //Adding a family to the arraylist which creates a new family object within the same application 
        
		
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
    public void testGetUserInput() {
        //Successfully reads user input and arraylist adds that input to next index available
        
		// Test data - these values may be changed in actual tests 
        String givenData = "Y.y.R\nb.e.E\nP.m.c\n";
        
        // Create object, parse data
        StitchPattern pattern = new StitchPattern(new File("some_file_name.txt"));
        pattern.setPattern(givenData);
        ArrayList<ArrayList<Character>> actualPattern = pattern.getPattern();
        String actualContents = convertToString(actualPattern);

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	
	//END OF APPLICATION TESTS 
	
	//TEST FAMILY
	
	@Test
    public void testFamilyConstructor() {
        
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
    public void testGetFamilyDefaultValues() {
        
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
    public void testGetFamilyID() {
        
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

	
	//END OF Family TESTS 
	
	//NUTRITION TESTS
	@Test
    public void testGetNutrition() {
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
	   int g1 = 96;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = Food(name1, g1, f1, p1, o1, c1);
	   
	   String name2 = "Wheat bread, loaf";
	   int g2 = 96;
	   int f2 = 0;
	   int p2 = 4;
	   int o2 = 0;
	   int c2 = 2192;
	   Food food1 = new Food(name2, g2, f2, p2 o2, c2);
	   
	   String name3= "Wheat bread, loaf";
	   int g3 = 96;
	   int f3 = 0;
	   int p3 = 4;
	   int o3 = 0;
	   int c3 = 2192;
	   Food food2 = new Food(name3, g3, f3, p3, o3, c3);

	   String name4= "Orange, dozen";
	   int g4 = 0;
	   int f4 = 100;
	   int p4 = 0;
	   int o4 = 0;
	   int c4 = 864;
	   Food food4 = new Food(name4, g4, f4, p4, o4, c4);
	   
	   String name5= "Orange, dozen";
	   int g5 = 0;
	   int f5 = 100;
	   int p5 = 0;
	   int o5 = 0;
	   int c5 = 864;
	   Food food5 = new Food(name5, g5, f5, p5, o5, c5);
	   
	   String name6 = "Eggs, dozen";
	   int g6 = 0;
	   int f6 = 0;
	   int p6 = 9;
	   int o6 = 91;
	   int c6 = 864;
	   Food food6 = new Food(name6, g6, f6, p6, o6, c6);
	   
	   LinkedList<Food> foodList = new LinkedList<Food>(); 
	   foodList.add(food1);
	   foodList.add(food2);
	   foodList.add(food3);
	   foodList.add(food4);
	   foodList.add(food5);
	   foodList.add(food6);
	   
	   

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	public void testOrderFormConstructor() {
		
		Inventory inventory = new Inventory();
		inventory.setInventory(foodList);
		
		int[] id = new int[4];
		id[0] = 1;
		id[1] = 2;
		id[2] = 3;
		id[3] = 4;
		int[][] array = new int[4][5];
		array[0][0] = 16;
		array[0][1] = 28;
		array[0][2] = 26;
		array[0][3] = 30;
		array[0][4] = 2500;
		
		array[1][0] = 16;
		array[1][1] = 28;
		array[1][2] = 26;
		array[1][3] = 30;
		array[1][4] = 2500;
		
		Family family
		
		ArrayList familyList = new ArrayList<Family>();
		family.add()
      	
    }
	
	
}
