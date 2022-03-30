//food
import java.sql.*;

public class Food{
  private Connection dbConnect;
  private ResultSet results;
  private int[][] calorieTable = new int[4][
  
  public Food(){
    initializeConnection();
    
  }
  
  public void initializeConnection(){
    try{
      this.dBConnect = DriverManager.getConnection(databaseURL, "student", "ensf409");
    }
    catch(SQLException e){
      e.printStackTrace(); //may need to be changed 
    }
  }
  
  public void getCalorieInfo()
