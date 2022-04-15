/**
Group Number: 01
Student Name: Sanika Shendye, Sobia Khan, Christina Wyllie, Maitry Rohit
Student ID: 30114344, 30115574, 30113679, 30117194
Email: sanika.shendye@ucalgary.ca, sobia.khan1@ucalgary.ca, christina.wyllie@ucalgary.ca, maitry.rohit@ucalgary.ca
Course: ENSF409
Final Project: DataBase.java
Date Submitted: April 18th, 2022
@author Sanika Shendye <a href="mailto:sanika.shendye@ucalgary.ca">
	sanika.shendye@ucalgary.ca</a>
@author Sobia Khan <a href="sobia.khan1@ucalgary.ca">
	sobia.khan1@ucalgary.ca</a>
@author Christina Wyllie <a href="christina.wyllie@ucalgary.ca">
	christina.wyllie@ucalgary.ca</a>
@author Maitry Rohit <a href="mailto:maitry.rohit@ucalgary.ca">
	maitry.rohitAucalgary.ca</a>
@version 1.19
@since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

/**
 * This class is responsible for maintaining the connection to the 
 * database and updating the database if an order is able to be fullfilled.
 * This class returns the inventory information and caloric information from 
 * the database.
 */
public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][6]; 
  private LinkedList<Food> inventory = new LinkedList<Food>(); //where we will pass the database info 
  
  /**
   * Sole class constructor that initializes the connection to the 
   * database and reads the client caloric needs and the initial
   * inventory that is present in the database.
   */
  public DataBase(){ 
    initializeConnection(); //initializes sql connection to database with user student, password ensf
    getCalorieData(); //gets calorie needs information from database 
    getInventoryData(); //gets inventory information from the database
  }
  

	/**
	* This method initializes the driver connection to the database using 
	* the username 'student' and password 'ensf'.
	*/
	private void initializeConnection(){
    try{
      this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory", "student", "ensf"); 
    }
    catch(SQLException e){
      System.out.println("Error connecting to database.");
      e.printStackTrace(); 
    }
    
  }
  
   /**
     * This method queries through the daily client caloric needs
     * and stores the information in a nested integer array that is
     * organized by caloric needs per category and client ID number.
     */
	private void getCalorieData(){
		try{
		  Statement myStmt = this.dbConnect.createStatement();
		  String query = "SELECT * FROM DAILY_CLIENT_NEEDS";
		  this.results = myStmt.executeQuery(query);
		  int i = 0; 
		  
		  while(this.results.next()){ //puts results into an integer nested array
			int g = results.getInt("WholeGrains");
			int p = results.getInt("Protein");
			int f = results.getInt("FruitVeggies");
			int o = results.getInt("Other");
			int c = results.getInt("Calories");
			
			this.calorieTable[i][0] = i + 1;
			this.calorieTable[i][1] = g;
			this.calorieTable[i][2] = f;
			this.calorieTable[i][3] = p;
			this.calorieTable[i][4] = o;
			this.calorieTable[i][5] = c;
			
				i++;
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
    /**
     * This method queries through the available food items that are present
     * in the database and stores them in a linked list of food objects
     * by iterating through each entry and calling the Food class 
     * constructor per entry.
     */
    public void getInventoryData(){
      try{
      Statement myStmt = this.dbConnect.createStatement();
      String query = "SELECT * FROM AVAILABLE_FOOD";
      this.results = myStmt.executeQuery(query);
      while(this.results.next()){
        int id = results.getInt("ItemID");
        String name = results.getString("Name");
        int g = results.getInt("GrainContent");
        int p = results.getInt("ProContent");
        int f = results.getInt("FVContent");
        int o = results.getInt("Other");
        int c = results.getInt("Calories");
        Food foodItem = new Food(id, name, g, f, p, o, c); //creates food item with each item in the database
        this.inventory.add(foodItem); //stores food item in linkedlist of food objects
        }
      }catch (SQLException ex) {
          //ex.printStackTrace();
       }
    }
	
    
    /**
     * This method returns the calorie table of the daily needs of all
     * possible family members that has been read and stored from the 
     * database.
     * 
     * @return 	returns an int array that contains daily caloric needs of family members
     */
    public int[][] getCalorieInfo()
    {
      return this.calorieTable; 
    }
	
    
    /** 
     * This method returns a LinkedList of food items that is indicative
     * of the inventory that is available in the database.
     * 
     * @return 	returns a linked list of food objects
     */
    public LinkedList<Food> getInventoryInfo(){
      return this.inventory;
    }
    
    
	/**
	 * This method iterates through the list of inventory to be removed that is
	 * passed to it and queries through the database, matching the name of the 
	 * food and the ID number in order to remove the item from the database. Upon
	 * successful removal of the entire list, a boolean true value is returned.
	 * This method is called after all hampers are created and determined that 
	 * they are able to be fullfilled.
	 * 
	* @param toBeRemoved  	a linked list of food items that will be iterated through and removed from the database
	* @return 	returns true if removal was successful, returns false otherwise
	*/
    public boolean updateDataBase(LinkedList<Food> toBeRemoved){
      boolean success = false;
      for(int k = 0; k < toBeRemoved.size(); k++) //iterated through the list of items to be removed from db
      {
         
        try{
         String query = "DELETE FROM AVAILABLE_FOOD WHERE ItemID = ? AND Name = ?"; //matches name and id 
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, Integer.toString(toBeRemoved.get(k).getFoodID()));
            myStmt.setString(2, toBeRemoved.get(k).getName());

            int rowCount = myStmt.executeUpdate();
            //System.out.println("Rows affected: " + rowCount);
            if(rowCount == 0)
            {
              return false;
            }
            else{
		success = true;
		}
   
            
            myStmt.close();
          }
          catch (SQLException ex) {
            ex.printStackTrace();
            return false;
          } 
      }
      if (success == true)
      {
        removeInventory(); //clears the inventory structure stored within database
      }
		  
      return success;
    }
	
	

    /**
     * This method clears the linked list stored in the structure and rereads from 
     * the database after the deletion to ensure that the most updated version of the
     * database is used.
     */
    private void removeInventory() 
    {
      this.inventory.clear();
      getInventoryData(); //inv stored in this structure now should match whats in inventory class structure
    }
    
 
  /**
   * This method closes the connection to the database upon completion of the order.
   */
    public void close() { 
		  try {
            this.results.close();
            this.dbConnect.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
     }
  }
