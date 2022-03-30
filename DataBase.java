//food
import java.sql.*;

public class DataBase{
  private Connection dbConnect;
  private ResultSet results;
  private
  
  public Food(){
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
      int[][] calorieTable = new int[4][6];
      while(this.results.next()){
        int g = result.getInt("WholeGrains");
        int p = result.getInt("Protein");
        int f = result.getInt("FruitVeggies");
        int o = result.getInt("Other");
        int c = result.getInt("Calories");
        
        calorieTable[i][0] = i + 1;
        calorieTable[i][1] = g;
        calorieTable[i][2] = p;
        calorieTable[i][3] = f;
        calorieTable[i][4] = o;
        calorieTable[i][5] = c;
        
        i++
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
      
      CaloricInfo cals = new CaloricInfo(calorieTable);
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
    
        
        

        
        
