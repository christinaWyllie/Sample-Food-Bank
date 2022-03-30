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
	   Food food1 = Food(name2, g2, f2, p2 o2, c2);
	   
	   String name3= "Wheat bread, loaf";
	   int g3 = 96;
	   int f3 = 0;
	   int p3 = 4;
	   int o3 = 0;
	   int c3 = 2192;
	   Food food1 = Food(name3, g3, f3, p3, o3, c3);

	   String name4= "Orange, dozen";
	   int g1 = 0;
	   int f1 = 0;
	   int p1 = 4;
	   int o1 = 0;
	   int c1 = 2192;
	   Food food1 = Food(name1, g1, f1, p1, o1, c1);
	   
	('Orange, dozen', 0, 100, 0, 0, 864), 
	('Orange, dozen', 0, 100, 0, 0, 864), 
	('Eggs, dozen', 0, 0, 9, 91, 864), 
		
		

        assertEquals("Value of contents did not match what was expected: ", givenData, actualContents);
    }
	
	
	
}
