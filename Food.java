//food

public class Food implements Calculate{
  private final String NAME;
  private final int FOODID;
  private final Nutrition NUTRITIONALVALUE;
  
  public Food(int itemID, String n, int g, int f, int p, int o, int c){
    this.NAME = n;
    calculateContent(g,f,p,o,c);
    this.FOODID =itemID;
  }
  
  public Nutrition getNutritionalValue(){
    return this.NUTRITIONALVALUE;
  }
  
  public int getFoodID(){
    return this.FOODID;
  }
  
  @Override
  public void calculateContent(int g, int f, int p, int o, int c){ //problem because method takes no args, so need to change interface or set local g,p,f,o,c. but UML changes either way
    int grain = (int)((double)(g/100) * c));
    int fv = (int)((double)(f/100) * c));
    int protein = (int)((double)(p/100) * c));
    int other = (int)((double)(o/100) * c));
    this.NUTRITIONALVALUE = new Nutrition(grain, protein, fv, other, c);
  }
    
}
