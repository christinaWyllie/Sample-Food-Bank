/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: OrderForm.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.12
@since 1.0
 */
package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


/**
 * OrderForm is a public class that uses the FormatOutput interface to 
 * standardize output that is printed to a text file that serves as the 
 * order form containing all of the information about the application
 * and the subsequent hampers that were created.
 */
public class OrderForm implements FormatOutput{
	private ArrayList<Family> family;
	private Inventory inventory;
	private ArrayList<HamperNutrition> hamper;
	private int numHampers;
  
 
 /**
  * Sole constructor for OrderForm that takes all parameters at completion
  * of hamper creation in application.
  * 
  * @param f	arraylist of family objects 
  * @param i	inventory object that is passed to update the inventory in the database
  * @param h	arraylist of all hampers so hamper information can be outputted
  * @param n	number of hampers within the application
  */
	public OrderForm(ArrayList<Family> f, Inventory i, ArrayList<HamperNutrition> h, int n){
		this.family = f;
		this.inventory = i;
		this.hamper = h;
		this.numHampers = n;
		try{
			removeFromDataBase();
		}catch(RemoveFromDataBaseFailedException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
  
  /**
   * This is a public method to remove from the database which calls the Inventory's remove method
   * and calls the print method if the removal was successful, else throws custom exception.
   * 
   * @throws RemoveFromDataBaseFailedException	thrown if the hamper items are not removed from the database 
   */
	public void removeFromDataBase()throws RemoveFromDataBaseFailedException{
		boolean value = inventory.removeDataBase();
		try{
			if(value){
				String file = "orderForm.txt";
				print(file);
			}
			else{
				throw new RemoveFromDataBaseFailedException();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	} 
  
 
  /**
   * This is a public method that prints all nessesary information
   * to an output file.
   * 
   * @throws IOException	thrown if the FileWriter object is unable to write to the text file
   */
	public void print(String file)throws IOException{
		int n = this.numHampers;
		FileWriter write = null;
		try{
			write = new FileWriter(file);
			write.append("Example Food Bank\nHamper Order Form\n\n");
			write.append("Name:" + "\n" + "Date:" + "\n\n" + "Original Request" + "\n");
			int i = 1;
			while(i<=n){
				int index = 1;
				for(Family fam : family){
					write.append("Hamper " + index + ": " + formatString(fam) + "\n");
					index++;
				}
				for(int k = 0; k< hamper.size(); k++){
					write.append("\nHamper " + i + " Items:\n");
					LinkedList<Food> food = hamper.get(k).getHamper();
					for(int j =0; j< food.size(); j++){
						write.append(food.get(j).getFoodID() + "\t");
						write.append(food.get(j).getName() + "\n");
					}
					i++;
					write.append("\n");
				}
				
				
			}
			
			write.close();
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	} 
	
  
  /**
   * This method overrides the formatString method from the FormatOutput
   * interface to format the string to print to the text file. 
   * 
   * @param fam 	Family object that contains information that should be printed to file
   * @return 	returns a string that has been formatted
   */
	@Override
	public String formatString(Family fam){
		int[] f = fam.getID();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<f.length; i++){
			if(f[i] != 0){
				builder.append(fam.getIDAtIndex(i)+ ", ");
			}
		}
		return builder.substring(0, builder.length()-2).toString();
	}
}
