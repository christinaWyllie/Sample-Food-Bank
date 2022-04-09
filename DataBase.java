//database
package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][6]; //could maybe make final if we want??
  private LinkedList<Food> inventory = new LinkedList<Food>(); //where we will pass this info 
  
  
  public DataBase(){
    initializeConnection();
    getCalorieData();
    getInventoryData();
  }
  
  private void initializeConnection(){
    try{
      this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory", "student", "ensf409"); //dont actually know database url so fix
    }
    catch(SQLException e){
      System.out.println("Error connecting to database.");
      e.printStackTrace(); //may need to be changed 
    }
  }
  
  private void getCalorieData(){
    try{
      Statement myStmt = this.dbConnect.createStatement();
      String query = "SELECT * FROM DAILY_CLIENT_NEEDS";
      this.results = myStmt.executeQuery(query);
      int i = 0; 
      
      while(this.results.next()){
        int g = results.getInt("WholeGrains");
        int p = results.getInt("Protein");
        int f = results.getInt("FruitVeggies");
        int o = results.getInt("Other");
        int c = results.getInt("Calories");
        
        this.calorieTable[i][0] = i + 1;
        this.calorieTable[i][1] = g;
        this.calorieTable[i][2] = p;
        this.calorieTable[i][3] = f;
        this.calorieTable[i][4] = o;
        this.calorieTable[i][5] = c;
        
        i++;
        }
     }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
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
        Food foodItem = new Food(id, name, g, f, p, o, c);
        this.inventory.add(foodItem);
        }
      }catch (SQLException ex) {
          ex.printStackTrace();
       }
    }
    
    public int[][] getCalorieInfo()
    {
      return this.calorieTable;
    }
    public LinkedList<Food> getInventoryInfo(){
      return this.inventory; //make sure that copy is deep???
      
      /* //Alternate implementation if just return doesnt work
      LinkedList<Food> returnValue = new LinkedList<Food>();
      for (int j = 0; j < this.inventory.size(); j++)
      {
        returnValue.add(this.inventory.get(j));
      }
      return returnValue;
      */
    }
    
    public boolean updateDataBase(LinkedList<Food> toBeRemoved){
      boolean success = false;
      for(int k = 0; k < toBeRemoved.size(); k++)
      {
         
        try{
         String query = "DELETE FROM AVAILABLE_FOOD WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, Integer.toString(toBeRemoved.get(k).getFoodID()));
                        
            int rowCount = myStmt.executeUpdate();
            //System.out.println("Rows affected: " + rowCount);
            if(rowCount != 0)
            {
              success = true;
            }
            
            myStmt.close();
          }
          catch (SQLException ex) {
            success = false;
            ex.printStackTrace();
            break;
          } 
      }
      if (success == true)
      {
        removeInventory();
      }
      return success;
    }
  
    public void removeInventory() //clears inventory we have stored in structure and re reads from database after deletions
    {
      this.inventory.clear();
      getInventoryData(); //inv stored in this structure now should match whats in inventory class structure
    }
  
    public void close() { //need to add to UML and add as a call when terminating application/orderform 
		  try {
            this.results.close();
            this.dbConnect.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
     }
  }

        
        
