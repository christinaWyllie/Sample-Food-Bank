//family

public class Family implements Calculate{
  private final Nutrition TOTAL;
  private int[] ID;
  
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
    
    for (int i = 0; i < this.ID.length; i++){
      double c = (double)getCalories(this.ID[i]);
      double g = (double)getGrainPercent(this.ID[i]);
      double p = (double)getProteinPercent(this.ID[i]);
      double f = (double)getFVPercent(this.ID[i]);
      double o = (double)getOtherPercent(this.ID[i]);
      double c = (double)getCalories(this.ID[i]);
      
      totalGrain += ((g/100)*c);
      totalProtein += ((p/100)*c);
      totalFV += ((f/100)*c);
      totalOther += ((o/100)*c);
      totalCalories += c;
    }
    
    this.TOTAL = new Nutrition(totalGrain, totalProtein, totalFV, totalOther, totalCalories);
  }
}
