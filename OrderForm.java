
/* 
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

//public class OrderForm, uses the interface FormatOutput
public class OrderForm implements FormatOutput{
	private ArrayList<Family> family;
	private Inventory inventory;
	private ArrayList<HamperNutrition> hamper;
	private int numHampers;
  
  // constructor for OrderForm 
  /*
  * @param Family f
  * @param Inventory i
  * @param ArrayList<HamperNutrition> h
  * @param int n
  *
  */
	public OrderForm(ArrayList<Family> f, Inventory i, ArrayList<HamperNutrition> h, int n)throws RemoveFromDataBaseFailedException{
		this.family = f;
		this.inventory = i;
		this.hamper = h;
		this.numHampers = n;
		removeFromDataBase();
	}
  
  // public method to remove from the database which calls the Inventory's remove method
  // calls the print method if the removal was successful, else throws custom exception
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
  
  //public method to print to an output file, throws IOException
	public void print(String file)throws IOException{
		int n = this.numHampers;
		FileWriter write = null;
		try{
			write = new FileWriter(file);
			write.append("Name:" + "\n" + "Date:" + "\n" + "Original Request" + "\n");
			while(n>-1){
				for(Family fam : family){
					write.append("Hamper " + n + ":" + formatString(fam));
					n--;
				}
			}
			for(int i = 0; i< hamper.size(); i++){
				LinkedList<Food> food = hamper.get(i).getHamper();
				for(int j =0; j< food.size(); j++){
					write.append(food.get(j).getFoodID() + "\t");
					write.append(food.get(j).getName() + "\n");
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	} 
	
  // interface method to format the string to print to the file 
	@Override
	public String formatString(Family fam){
		int[] f = fam.getID();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<f.length; i++){
			if(f[i] != 0){
				builder.append(fam.getIDAtIndex(i)+ ", ");
			}
		}
		return builder.substring(0, builder.length()-1).toString();
	}
  
	/*public String toString(int index){
		if(index == 0){
			return "Adult Male";
		}
		else if(index ==1){
			return "Adult Female";
		}
		else if(index ==2){
			return "Child over 8";
		}
		else{
			return "Child under 8";
		}
	} */
	 
}
