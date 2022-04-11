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

package edu.ucalgary.ensf409;


import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class TestOrderForm{
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