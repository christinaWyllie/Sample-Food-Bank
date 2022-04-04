
package edu.ucalgary.ensf409;

public class OrderForm implements FormatOutput{
  private Family family;
  private Inventory inventory;
  private HamperNutrition hamper;
  
  public OrderFrom(Family f, Inventory i, HamperNutrition h)throws IOException{
    this.family = f;
    this.inventory = i;
    this.hamper = h;
  }
  
  public void removeFromDataBase(){
    
  } 
  
  public void print()throws IOException{
    String fileName = "orderForm.txt";
    FileWriter write = null;
    try{
      write = new FileWriter(new File(fileName));
      
    }
    
  } 
  
  @Override
  public void formatString(){
    
  }
  
}
