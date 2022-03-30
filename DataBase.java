//food
import java.sql.*;

public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][6];
  
  public DataBase(){
    initializeConnection();
    getCalorieInfo();
  }
  
  public void initializeConnection(){
    try{
      this.dBConnect = DriverManager.getConnection(databaseURL, "student", "ensf409"); //dont actually know database url so fix
    }
    catch(SQLException e){
      e.printStackTrace(); //may need to be changed 
    }
  }
  
  public void getCalorieInfo(){
    try{
      Statement myStmt = this.dbConnect.createStatement();
      String query = "SELECT * FROM DAILY_CLIENT_NEEDS";
      this.results = myStmt.executeQuery(query);
      int i = 0; 
      
      while(this.results.next()){
        int g = result.getInt("WholeGrains");
        int p = result.getInt("Protein");
        int f = result.getInt("FruitVeggies");
        int o = result.getInt("Other");
        int c = result.getInt("Calories");
        
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
    
    public void getInventoryInfo(){
      try{
      Statement myStmt = this.dbConnect.createStatement();
      String query = "SELECT * AVAILABLE_FOOD";
      this.results = myStmt.executeQuery(query);
      while(this.results.next()){
      }
      }
      
    
    public int getCalories(int id){
      return this.caloriesTable[id - 1][5];
    }
    
    public int getGrainPercent(int id){
      return this.caloriesTable[id - 1][1];
    }
    
    public int getProteinPercent(int id){
      return this.caloriesTable[id - 1][2];
    }
    
    public int getFVPercent(int id){
      return this.caloriesTable[id - 1][3];
    }
    
    public int getOtherPercent(int id){
      return this.caloriesTable[id - 1][4];
    }
  }
    
        
        

        
        
