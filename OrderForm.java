
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
	private Family family;
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
	public OrderForm(Family f, Inventory i, ArrayList<HamperNutrition> h, int n){
		this.family = f;
		this.inventory = i;
		this.hamper = h;
		this.numHampers = n;
	}
  
  // public method to remove from the database which calls the Inventory's remove method
  // calls the print method if the removal was successful, else throws custom exception
	public void removeFromDataBase()throws RemoveFromDataBaseFailedException{
		boolean value = inventory.removeDataBase();
		if(value){
			print();
		}
		else{
			throw new RemoveFromDataBaseFailedException();
		}
	} 
  
  //public method to print to an output file, throws IOException
	public void print()throws IOException{
		int n = this.numHampers;
		String fileName = "orderForm.txt";
		FileWriter write = null;
		try{
			write = new FileWriter(new File(fileName));
			write.append("Name:" + "\n" + "Date:" + "\n" + "Original Request" + "\n");
			while(n>-1){
				write.append("Hamper " + n + ":" + formatString());
				n--;
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
	public String formatString(){
		int[] fam = family.getFamilyMembers();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<fam.length; i++){
			if(fam[i] != 0){
				builder.append(family.getID(i)+ ", ");
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
