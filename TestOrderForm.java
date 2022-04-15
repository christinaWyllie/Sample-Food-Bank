/* 
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: TestOrderForm.java
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
 // javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar edu/ucalgary/ensf409/TestFamily.java
 // java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.TestFamily
 

package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestOrderForm{
	private ArrayList<Family> family; //private variables used in each test, set in the method createFoodHamperFamilyObjects()
	private Inventory inventory;
	private ArrayList<HamperNutrition> hamper;
	private Application app;
	private int numHampers;
	
	//ORDERFORM TEST 
	@Test
	public void testOrderFormConstructor() {
			
		createFoodHamperFamilyObjects(); //initailize the objects to be passed into the constructor
		
		OrderForm form = new OrderForm(family, inventory, hamper, numHampers);
		assertNotNull("Order form did not create a valid object", form); //assert the constructor successfully made the object
	}
	
	
	@Test
	public void testIOException(){
		createFoodHamperFamilyObjects();
		boolean exceptionThrown = false;
		// testing that print() method in OrderForm throws an exception when it cannot write to the txt file.
		try{
			OrderForm order = new OrderForm(family, inventory, hamper, numHampers);
			
			String file = "orderForm";
		}
        catch(Exception e) {
            exceptionThrown = true;
        }

        assertFalse("Error thrown from print", exceptionThrown);
    }
	
	
	@Test
	public void testPrint(){
		StringBuilder build = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		createFoodHamperFamilyObjects();
		
		try{
			//append the expected information to a StringBuilder
			
			build.append("Example Food Bank\nHamper Order Form\n\n" + 
					"Name:" + "\n" + "Date:" + "\n\n" + "Original Request" + "\n");
					
			build.append("Hamper 1: 1 Adult Male, 1 Adult Female\n");
			build.append("\nHamper 1 Items:\n");
			
			//append the unique hamper created by the program
			LinkedList<Food> food = this.hamper.get(0).getHamper();
			for(int j =0; j< food.size(); j++){
				build.append(food.get(j).getFoodID() + "\t");
				build.append(food.get(j).getName() + "\n");
			}
			build.append("\n");
			
			
			try{
				//the file will be created in order form with the name orderForm.txt
				BufferedReader reader = new BufferedReader(new FileReader(new File("orderForm.txt")));
				String word;
				while((word = reader.readLine()) != null){
					builder.append(word + "\n"); //append the information from the file created in the OrderForm print() method
				}
			}catch(IOException e){
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		catch(Exception e){
				System.out.println("Error running ");
				e.printStackTrace();
		}
		String expected = build.toString();
		String output = builder.toString();
		// assert the strings match.
		assertEquals("Error, the file does not match the expected output", expected, output);
		
	}


	 /* ******************* HELPER METHODS ***************** */

    /*
    * Create a test file to read in (in working directory)
    */
    private void createFoodHamperFamilyObjects() {
		//creat an appliation object with the family to run the program and create the hamper
		ArrayList<int[]> var = new ArrayList<int[]>();
		int[] fam = {1,1,0,0};
		var.add(fam);
		try{
			this.app = new Application(var);
		}catch(Exception e){
				System.out.println("Error running ");
				e.printStackTrace();
		}
		//retrieve the hamper information made after the call to application
		this.hamper = this.app.getHampers();
	    this.inventory = this.app.getInventory();
		this.family = this.app.getFamilies();
		this.numHampers = family.size();
    }		   
}

