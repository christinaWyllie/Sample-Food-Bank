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

public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][6]; 
  private LinkedList<Food> inventory = new LinkedList<Food>(); //where we will pass the database info 
  
  
  public DataBase(){ //class constructor
    initializeConnection(); //initializes sql connection to database with user student, password ensf
    getCalorieData(); //gets calorie needs information from database 
    getInventoryData(); //gets inventory information from the database
  }
  
//initializes sql connection to database with user student, password ensf
  private void initializeConnection(){
    try{
      this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory", "student", "ensf"); 
    }
    catch(SQLException e){
      System.out.println("Error connecting to database.");
      e.printStackTrace(); 
    }
    
  }
  //gets calorie needs information from database 
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
	
    //gets inventory information from the database
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
	
    //returns calorie needs for all possible family members
    public int[][] getCalorieInfo()
    {
      return this.calorieTable; 
    }
	
    //returns list of items in the inventory in database
    public LinkedList<Food> getInventoryInfo(){
      return this.inventory;
    }
    
     //is called after all hampers are created using the linkedlist, this is the final stage where the 
     //database is fully updated and the used hamper items are removed
	
	/**
	* @param LinkedList<Food> toBeRemoved
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
	
	
    //clears inventory we have stored in structure and re reads from database after deletions
    private void removeInventory() 
    {
      this.inventory.clear();
      getInventoryData(); //inv stored in this structure now should match whats in inventory class structure
    }
  //closes the connection to the database at the completion of an order
    public void close() { 
		  try {
            this.results.close();
            this.dbConnect.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
     }
  }

     
