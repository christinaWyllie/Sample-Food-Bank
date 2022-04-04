
package edu.ucalgary.ensf409;

public class OrderForm implements FormatOutput{
  private Family family;
  private Inventory inventory;
  private HamperNutrition hamper;
  private int numHampers;
  
  public OrderFrom(Family f, Inventory i, HamperNutrition h, int n){
    this.family = f;
    this.inventory = i;
    this.hamper = h;
    this.numHampers = n;
  }
  
  public void removeFromDataBase(){
    
  } 
  
  public void print()throws IOException{
    String fileName = "orderForm.txt";
    FileWriter write = null;
    int[] fam = family.getFamilyMembers();
    try{
      write = new FileWriter(new File(fileName));
      write.append("Name:" + "\n" + "Date:" + "\n" + "Original Request" + "\n");
      while(n){
        formatString();
        n--;
      } 
     
    }
    
  } 
  
  @Override
  public void formatString(){
    StringBuilder builder = new StringBuilder();
    write.append("Hamper " + n+ ":");
    for(int i = 0; i<fam.length; i++){
         if(fam[i] != null){
           int count = fam[i];
           builder.append(n + toString(i)+ ", ");
         }
    }
    write.append(builder.substring(0, builder.length()-1));
  }
  
  public String toString(int index){
    if(index == 0){
      return "Adult Male";
    }
    else if(index ==1){
      return "Adult Female";
    }
    else if(index ==2){
      return "Child under 8";
    }
    else{
      return "Child over 8";
    }
  } 
  
}
