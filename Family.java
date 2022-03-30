//family

public class Family implements Calculate{
  private final Nutrition TOTAL;
  private int[] ID;
  private Food calsData = new Food(); 
  
  public Family(int[] ID){
    this.ID = ID;
    calculateCalories();
  }
  
  public String getID(){
    //returns either ID numbers or the actual names(ex.adult male) as string
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
        
        double c = (double)calsData.getCalories(i);
        double g = (double)calsData.getGrainPercent(i);
        double p = (double)calsData.getProteinPercent(i);
        double f = (double)calsData.getFVPercent(i);
        double o = (double)calsData.getOtherPercent(i);
      
      
        totalGrain += ((g/100)*c * this.ID[i]);
        totalProtein += ((p/100)*c * this.ID[i]);
        totalFV += ((f/100)*c * this.ID[i]);
        totalOther += ((o/100)*c * this.ID[i]);
        totalCalories += (c* this.ID[i]);
      }
    }
    
    this.TOTAL = new Nutrition(totalGrain, totalProtein, totalFV, totalOther, totalCalories);
  }
}
