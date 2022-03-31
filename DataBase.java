//food
import java.sql.*;
import java.util.*;

public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][6];
  private LinkedList<Food> inventory = new LinkedList<Food>(); //where we will pass this info 
  
  
  public DataBase(){
    initializeConnection();
    getCalorieData();
    getInventoryData();
  }
  
  public void initializeConnection(){
    try{
      this.dBConnect = DriverManager.getConnection(databaseURL, "student", "ensf409"); //dont actually know database url so fix
    }
    catch(SQLException e){
      e.printStackTrace(); //may need to be changed 
    }
  }
  
  public void getCalorieData(){
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
        
        i++
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getInventoryData(){
      try{
      Statement myStmt = this.dbConnect.createStatement();
      String query = "SELECT * AVAILABLE_FOOD";
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
        this.inventory.add(foodItem)
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
      return this.inventory;
    }
    
    
  }
    
        
        

        
        
