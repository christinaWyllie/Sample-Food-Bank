//family

public class Family implements Calculate{
  private final Nutrition TOTAL;
  private int[] ID;
  private int[][] calorieData; 
  
  public Family(int[] ID, int[][] caloricInfo){
    this.ID = ID;
    this.calorieData = caloricInfo; 
    calculateCalories();
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
  public calculateCalories(){
    //some sort of access to data base, using conventions g, p, f, o, c 
    int totalGrain = 0; 
    int totalProtein = 0;
    int totalFV = 0;
    int totalOther = 0;
    int totalCalories = 0;
    int i = 1;
    int index = 0;
    while (i != 5){
      if (this.ID[index] != 0){
        
        double c = (double)this.calorieData[i-1][5];
        double g = (double)this.calorieData[i-1][1];
        double p = (double)this.calorieData[i-1][2];
        double f = (double)this.calorieData[i-1][3];
        double o = (double)this.calorieData[i-1][4];
      
      
        totalGrain += ((g/100)*c * this.ID[index]);
        totalProtein += ((p/100)*c * this.ID[index]);
        totalFV += ((f/100)*c * this.ID[index]);
        totalOther += ((o/100)*c * this.ID[index]);
        totalCalories += (c* this.ID[index]);
       
      }
      i++;
      index++;
    }
    this.TOTAL = new Nutrition(totalGrain, totalProtein, totalFV, totalOther, totalCalories);
  }
  
}
