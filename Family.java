//family

public class Family implements Calculate{
  private final Nutrition TOTAL;
  private int[] ID;
  private int[][] calorieData; 
  
  public Family(int[] ID, int[][] caloricInfo){
    this.ID = ID;
    this.calorieData = caloricInfo; 
    this.TOTAL = calculateContent(); //same inconsistnecy as below, sorry Tina
  }
  
  public String getID(){
    //returns either ID numbers or the actual names(ex.adult male) as string
    for (int i = 0; i < 4; i++){
      if (this.ID[i] != 0)
      {
        //not done
      }
    }
  }
  public Nutrition getTotal(){
    return this.TOTAL;
  }
  
  @Override
  public Nutrition calculateContent(){ //need to fix with UML, but maybe could just send 0's in to make it work with food(check food class for context)
    //using conventions g, p, f, o, c 
    int totalGrain = 0; 
    int totalProtein = 0;
    int totalFV = 0;
    int totalOther = 0;
    int totalCalories = 0;
    int i = 1;
    int index = 0;
    while (i != 5){
      if (this.ID[index] != 0){
        
        int c = this.calorieData[i-1][5];
        int g = this.calorieData[i-1][1];
        int p = this.calorieData[i-1][2];
        int f = this.calorieData[i-1][3];
        int o = this.calorieData[i-1][4];
      
      
        totalGrain += (int)((g/100.0)*c * this.ID[index]);
        totalProtein += (int)((p/100.0)*c * this.ID[index]);
        totalFV += (int)((f/100.0)*c * this.ID[index]);
        totalOther += (int)((o/100.0)*c * this.ID[index]);
        totalCalories += (c* this.ID[index]);
       
      }
      i++;
      index++;
    }
    Nutrition n = new Nutrition(totalGrain, totalProtein, totalFV, totalOther, totalCalories);
    return n;
  }
  
}
