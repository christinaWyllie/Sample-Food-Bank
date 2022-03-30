//Nutrition
package edu.ucalgary.ensf409;

public class Nutrition{
  private final int GRAIN;
  private final int PROTEIN;
  private final int FV;
  private final int OTHER;
  private final int CALORIES;
  
  public Nutrition(int g, int p, int f, int o, int c)
  {
    this.GRAIN = g;
    this.PROTEIN = p;
    this.FV = f;
    this.OTHER = o;
    this.CALORIES = c;
  }
  
  public int getGrain(){
    return this.GRAIN;
  }
  
  public int getProtein(){
    return this.PROTEIN;
  }
    
  public int getFV(){
    return this.FV;
  }
  
  public int getOther(){
    return this.OTHER;
  }
  
  public int getCalories(){
    return this.CALORIES;
  }
}
  
  
