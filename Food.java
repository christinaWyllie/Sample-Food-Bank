//food

public class Food implements Calculate{
  private final String NAME;
  private final int FOODID;
  private final Nutrition NUTRITIONALVALUE;
  
  public Food(int itemID, String n, int g, int f, int p, int o, int c){
    this.NAME = n;
    this.NUTRITIONALVALUE = calculateContent(g,f,p,o,c);
    this.FOODID =itemID;
  }
  
  public Nutrition getNutritionalValue(){
    return this.NUTRITIONALVALUE;
  }
  
  public String getName() //added, not on UML
  {
	  return this.NAME;
  }
  
  public int getFoodID(){
    return this.FOODID;
  }
  
  @Override //changed to return nutrition object, UML is fine for that part
  public Nutrition calculateContent(int g, int f, int p, int o, int c){ //problem because method takes no args, so need to change interface or set local g,p,f,o,c. but UML changes either way
    int grain = (int)((g/100.0) * c);
    int fv = (int)((f/100.0) * c);
    int protein = (int)((p/100.0) * c);
    int other = (int)((o/100.0) * c);
    Nutrition toBeSet = new Nutrition(grain, protein, fv, other, c);
    return toBeSet;
  }
  
    
}
